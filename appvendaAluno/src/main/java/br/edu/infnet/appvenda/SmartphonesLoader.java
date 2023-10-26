package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Smartphones;
import br.edu.infnet.appvenda.model.service.SmartphonesService;

@Order(3)
@Component
public class SmartphonesLoader implements ApplicationRunner {
	
	@Autowired
	private SmartphonesService smartphonesService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/smartphones.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Smartphones smartphones = new Smartphones();
			
			smartphones.setCodigo(Integer.valueOf(campos[0]));
			smartphones.setDescricao(campos[1]);
			smartphones.setEstoque(Boolean.valueOf(campos[2]));
			smartphones.setPreco(Float.valueOf(campos[3]));
			smartphones.setFabricante(campos[4]);
			smartphones.setModelo(campos[5]);
			smartphones.setGarantiaMeses(Integer.valueOf(campos[6]));
			smartphones.setArmazenamento(Integer.valueOf(campos[7]));
			
			smartphonesService.incluir(smartphones);				
			linha = leitura.readLine();
		}
		
		for(Smartphones smartphones: smartphonesService.obterLista()) {
			System.out.println("[Smartphones] " + smartphones);			
		}
		
		leitura.close();
	}
}