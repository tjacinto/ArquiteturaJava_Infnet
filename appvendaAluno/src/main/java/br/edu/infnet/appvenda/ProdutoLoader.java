package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Eletroportateis;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Smartphones;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produtos.txt");		
		try (BufferedReader leitura = new BufferedReader(file)) {
			String linha = leitura.readLine();

			String[] campos = null;
			Vendedor vendedor = new Vendedor();

			while(linha != null) {
				
				campos = linha.split(";");
				
				switch (campos[9]) {
				case "S":
					Smartphones smartphones = new Smartphones();
					smartphones.setCodigo(Integer.valueOf(campos[0]));
					smartphones.setDescricao(campos[1]);
					smartphones.setEstoque(Boolean.valueOf(campos[2]));
					smartphones.setPreco(Float.valueOf(campos[3]));
					smartphones.setFabricante(campos[4]);
					smartphones.setModelo(campos[5]);
					smartphones.setGarantiaMeses(Integer.valueOf(campos[6]));
					smartphones.setArmazenamento(Integer.valueOf(campos[7]));
					
					vendedor.setId(Integer.valueOf(campos[8]));
					
					smartphones.setVendedor(vendedor);

					produtoService.incluir(smartphones);
					break;

				case "E":
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
					
					produtoService.incluir(eletroportateis);
					break;

				default:
					break;
				}
										
				linha = leitura.readLine();
			}
		}
		
		for (Produto produto : produtoService.obterLista()) {
			System.out.println("[Produtos] " + produto);
		}
	}
}