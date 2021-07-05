package br.com.grupocidade.b2click.ws.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupocidade.b2click.ws.model.Razao;

@Repository
public interface RazaoRepository extends JpaRepository<Razao, String> {
	
	boolean existsByAcesso(String acesso);

	Optional<List<Razao>> findByDataBetweenAndCodEmpresa(Date dataInicial, Date dataFinal,
			Integer CodEmpresa);

}
