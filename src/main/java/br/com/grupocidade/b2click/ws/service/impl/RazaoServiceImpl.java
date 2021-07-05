package br.com.grupocidade.b2click.ws.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.grupocidade.b2click.ws.config.Token;
import br.com.grupocidade.b2click.ws.error.ResourceConflictErrorException;
import br.com.grupocidade.b2click.ws.error.ResourceNotFoundException;
import br.com.grupocidade.b2click.ws.model.Razao;
import br.com.grupocidade.b2click.ws.model.request.RazaoParams;
import br.com.grupocidade.b2click.ws.model.request.RazaoWS;
import br.com.grupocidade.b2click.ws.model.response.RazaoResponse;
import br.com.grupocidade.b2click.ws.repository.RazaoRepository;
import br.com.grupocidade.b2click.ws.service.RazaoService;

@Service
@Transactional
public class RazaoServiceImpl implements RazaoService {

	@Autowired
	RazaoRepository repository;

	String URL_WS = "https://webservice.b2click.com/erp/redesoft/b2click/financeiro/razao";

	@Override
	public List<Razao> listFilterBy(RazaoParams filter) throws ParseException {

		Date dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse(filter.getDataInicial());
		Date dataFinal = new SimpleDateFormat("dd/MM/yyyy").parse(filter.getDataFinal());

		return repository.findByDataBetweenAndCodEmpresa(dataInicial, dataFinal, filter.getCodEmpresa()).get();
	}

	public List<RazaoWS> listTitleInWebService(RazaoParams filter) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", Token.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_WS)
				.queryParam("dataInicial", filter.getDataInicial()).queryParam("dataFinal", filter.getDataFinal())
				.queryParam("codEmpresa", filter.getCodEmpresa());

		HttpEntity<RazaoResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				RazaoResponse.class);

		if (response.getBody().getResponse() == null) {
			throw new ResourceNotFoundException("Código Erro: ".concat(response.getBody().getCodigo().toString())
					.concat(" \n ").concat("Erro: " + response.getBody().getMensagem()));
		}

		if (response.getBody().getResponse().size() == 0) {
			throw new ResourceNotFoundException("Nenhum registro encontrado!");
		}

		return response.getBody().getResponse();

	}

	@Override
	public List<Razao> saveInBDRazaoFilterBy(RazaoParams filter) throws ParseException {

		List<RazaoWS> list = listTitleInWebService(filter);
		List<Razao> listRazao = new ArrayList<>();
		List<Razao> listImported = new ArrayList<>();

		// PREENCHE A LISTA DE TITULOS
		for (RazaoWS r : list) {
			Razao razao = new Razao();
			razao.setCodEmpresa(r.getCod_empresa());
			razao.setAcesso(r.getAcesso());
			razao.setNome(r.getNome());
			razao.setOrigem(r.getOrigem());
			razao.setLancamento(r.getLancamento());
			razao.setPlanilha(r.getPlanilha());
			razao.setDocumento(r.getDocumento());
			razao.setData(r.getData().length() <= 1 ? null : new SimpleDateFormat("yyyy-MM-dd").parse(r.getData()));
			razao.setDataExtrato(r.getData_extrato().length() <= 1 ? null
					: new SimpleDateFormat("yyyy-MM-dd").parse(r.getData_extrato()));
			razao.setContrapartida(r.getContrapartida());
			razao.setCentroCusto(r.getCentro_custo());
			razao.setHistorico(r.getHistorico());
			razao.setDebito(r.getDebito());
			razao.setCredito(r.getCredito());
			razao.setSaldo(r.getSaldo());
			razao.setTipoSaldo(r.getTipo_saldo());
			razao.setAgente(r.getAgente());
			razao.setIdSistema(1);
			razao.setIdEmpresa(1);
			listRazao.add(razao);

		}

		// AQUI VAI FICAR AS VALIDAÇÕES
		for (Razao r : listRazao) {
			if (repository.existsByAcesso(r.getAcesso())) {
				throw new ResourceConflictErrorException("Importação cancelada, o Titulo: "
						.concat(r.getAcesso().toString()).concat(" Já foi importado."));
			}
		}

		// SE TUDO ACIMA DER CERTO, ENTÃO ELE VAI SALVAR OS DADOS NO BANCO.

		for (Razao r : listRazao) {
			r = repository.save(r);
			listImported.add(r);
		}

		listRazao = null;
		list = null;
		return listImported;
	}

}
