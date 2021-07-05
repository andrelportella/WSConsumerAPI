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
import br.com.grupocidade.b2click.ws.model.Titulo;
import br.com.grupocidade.b2click.ws.model.request.TituloParams;
import br.com.grupocidade.b2click.ws.model.request.TituloWS;
import br.com.grupocidade.b2click.ws.model.response.TituloResponse;
import br.com.grupocidade.b2click.ws.repository.TituloRepository;
import br.com.grupocidade.b2click.ws.service.TituloService;

@Service
@Transactional
public class TituloServiceImpl implements TituloService {

	@Autowired
	TituloRepository repository;

	String URL_WS = "https://webservice.b2click.com/erp/redesoft/b2click/financeiro/titulo";

	@Override
	public List<Titulo> listFilterBy(TituloParams filter) throws ParseException {

		Date dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse(filter.getDataInicial());
		Date dataFinal = new SimpleDateFormat("dd/MM/yyyy").parse(filter.getDataFinal());
		
		return repository
				.findByDataVencimentoBetweenAndCentroCusto(dataInicial, dataFinal, filter.getCodEmpresa().toString())
				.get();
	}

	public List<TituloWS> listTitleInWebService(TituloParams filter) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", Token.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_WS)
				.queryParam("dataInicial", filter.getDataInicial()).queryParam("dataFinal", filter.getDataFinal())
				.queryParam("cpfCnpj", filter.getCpfCnpj()).queryParam("documento", filter.getDocumento())
				.queryParam("codVenda", filter.getCodVenda()).queryParam("tipo", filter.getTipo())
				.queryParam("situacao", filter.getSituacao()).queryParam("pdv", filter.getPdv())
				.queryParam("codEmpresa", filter.getCodEmpresa());

		HttpEntity<TituloResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				TituloResponse.class);

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
	public List<Titulo> saveInBDTitleFilterBy(TituloParams filter) throws ParseException {

		List<TituloWS> list = listTitleInWebService(filter);
		List<Titulo> listTitle = new ArrayList<>();
		List<Titulo> listImported = new ArrayList<>();

		// PREENCHE A LISTA DE TITULOS
		for (TituloWS t : list) {
			Titulo title = new Titulo();
			title.setCentroCusto(filter.getCodEmpresa().toString());
			title.setCpfCnpj(t.getCpfCnpj());
			title.setCodigo(t.getCodigo());
			title.setDataEmissao(new SimpleDateFormat("dd/MM/yyyy").parse(t.getEmissao()));
			title.setDataVencimento(new SimpleDateFormat("dd/MM/yyyy").parse(t.getVencimento()));
			title.setHistorico("");
			title.setIdEmpresa(filter.getCodEmpresa());
			title.setIdSistema(1);
			title.setNatureza("");
			title.setSituacao(t.getSituacao());
			title.setTipo(t.getTipo());
			title.setValor(Double.parseDouble(t.getValor()));
			listTitle.add(title);
		}

		// AQUI VAI FICAR AS VALIDAÇÕES
		for (Titulo t : listTitle) {
			if (repository.existsByCodigo(t.getCodigo())) {
				throw new ResourceConflictErrorException("Importação cancelada, o Titulo: "
						.concat(t.getCodigo().toString()).concat(" Já foi importado."));
			}
		}

		// SE TUDO ACIMA DER CERTO, ENTÃO ELE VAI SALVAR OS DADOS NO BANCO.

		for (Titulo t : listTitle) {
			t = repository.save(t);
			listImported.add(t);
		}

		listTitle = null;
		list = null;
		return listImported;
	}

}
