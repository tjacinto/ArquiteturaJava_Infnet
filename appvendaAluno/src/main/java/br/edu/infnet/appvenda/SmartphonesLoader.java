package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Smartphones;

@Order(3)
@Component
public class SmartphonesLoader implements ApplicationRunner {
	
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
									
			linha = leitura.readLine();
			System.out.println("[Smartphones] " + smartphones);	
		}
		
		leitura.close();
	}
}