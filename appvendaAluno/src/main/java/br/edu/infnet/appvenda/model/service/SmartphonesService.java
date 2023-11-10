package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Smartphones;
import br.edu.infnet.appvenda.model.repository.SmartphonesRepository;

@Service
public class SmartphonesService {

	@Autowired
	private SmartphonesRepository smartphonesRepository;

	public void incluir(Smartphones smartphones) {
		smartphonesRepository.save(smartphones);
	}

	public Collection<Smartphones> obterLista() {
		return (Collection<Smartphones>) smartphonesRepository.findAll();
	}

	public long obterQtde() {
		return smartphonesRepository.count();
	}

	public void excluir(Integer id) {
		smartphonesRepository.deleteById(id);
	}
}