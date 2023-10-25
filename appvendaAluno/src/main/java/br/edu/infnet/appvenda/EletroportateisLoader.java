package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Eletroportateis;

@Order(4)
@Component
public class EletroportateisLoader implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/eletroportateis.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Eletroportateis eletroportateis = new Eletroportateis();
			
			eletroportateis.setCodigo(Integer.valueOf(campos[0]));
			eletroportateis.setDescricao(campos[1]);
			eletroportateis.setEstoque(Boolean.valueOf(campos[2]));
			eletroportateis.setPreco(Float.valueOf(campos[3]));
			eletroportateis.setFabricante(campos[4]);
			eletroportateis.setModelo(campos[5]);
			eletroportateis.setVoltagem(Integer.valueOf(campos[6]));
			eletroportateis.setBateria(campos[7]);
									
			linha = leitura.readLine();
			System.out.println("[Eletroportateis] " + eletroportateis);	
		}
		
		leitura.close();
	}
}