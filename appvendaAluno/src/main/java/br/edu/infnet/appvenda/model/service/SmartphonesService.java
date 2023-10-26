package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Smartphones;

@Service
public class SmartphonesService {
	
	
	private Map<Integer, Smartphones> mapaSmartphones = new HashMap<Integer, Smartphones>();

	public void incluir(Smartphones smartphones) {
		mapaSmartphones.put(smartphones.getCodigo(), smartphones);
	}
	
	public Collection<Smartphones> obterLista(){	
		return mapaSmartphones.values();
	}
}