package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Vendedor;

@Order(2)
@Component
public class VendedorLoader implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/vendedor.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Vendedor vendedor = new Vendedor();
			
			vendedor.setNome(campos[0]);
			vendedor.setCpf(campos[1]);
			vendedor.setEmail(campos[2]);
									
			linha = leitura.readLine();
			System.out.println("[Vendedor] " + vendedor);	
		}
		
		leitura.close();
	}
}