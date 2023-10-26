package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Eletroportateis;

@Service
public class EletroportateisService {
	
	
	private Map<Integer, Eletroportateis> mapaEletroportateis = new HashMap<Integer, Eletroportateis>();

	public void incluir(Eletroportateis eletroportateis) {
		mapaEletroportateis.put(eletroportateis.getCodigo(), eletroportateis);
	}
	
	public Collection<Eletroportateis> obterLista(){	
		return mapaEletroportateis.values();
	}
}