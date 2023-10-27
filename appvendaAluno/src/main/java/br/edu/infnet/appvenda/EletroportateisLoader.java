package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Eletroportateis;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.EletroportateisService;

@Order(4)
@Component
public class EletroportateisLoader implements ApplicationRunner {

	@Autowired
	private EletroportateisService eletroportateisService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/eletroportateis.txt");
		try (BufferedReader leitura = new BufferedReader(file)) {
			String linha = leitura.readLine();

			String[] campos = null;
			Vendedor vendedor = new Vendedor();

			while (linha != null) {

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
				
				vendedor.setId(Integer.valueOf(campos[8]));
				
				eletroportateis.setVendedor(vendedor);

				eletroportateisService.incluir(eletroportateis);
				linha = leitura.readLine();
			}
		}

		for (Eletroportateis eletroportateis : eletroportateisService.obterLista()) {
			System.out.println("[Eletroportateis] " + eletroportateis);
		}
	}
}