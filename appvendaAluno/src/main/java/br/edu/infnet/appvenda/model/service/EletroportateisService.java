package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Eletroportateis;
import br.edu.infnet.appvenda.model.repository.EletroportateisRepository;

@Service
public class EletroportateisService {
	
	@Autowired
	private EletroportateisRepository eletroportateisRepository;

	public void incluir(Eletroportateis eletroportateis) {
		eletroportateisRepository.save(eletroportateis);
	}
	
	public Collection<Eletroportateis> obterLista(){	
		return (Collection<Eletroportateis>) eletroportateisRepository.findAll();
	}
}