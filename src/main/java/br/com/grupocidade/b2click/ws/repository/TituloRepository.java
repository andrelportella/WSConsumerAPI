package br.com.grupocidade.b2click.ws.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupocidade.b2click.ws.model.Titulo;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {

	boolean existsByCodigo(Integer codigo);

	Optional<List<Titulo>> findByDataVencimentoBetweenAndCentroCusto(Date vencimentoInicial, Date vencimentoFinal,
			String centroCusto);

}
