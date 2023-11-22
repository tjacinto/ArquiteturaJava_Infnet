package br.edu.infnet.vendasApi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.vendasApi.model.domain.Informacao;

@Repository
public interface InformacaoRepository extends CrudRepository<Informacao, Integer> {

}