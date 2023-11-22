package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.EletroportateisService;
import br.edu.infnet.appvenda.model.service.InformacaoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.SmartphonesService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {

	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private SmartphonesService smartphonesService;
	@Autowired
	private EletroportateisService eletroportateisService;
	@Autowired
	private InformacaoService informacaoService;

	@GetMapping(value = "/")
	public String showHome(Model model) {

		model.addAttribute("informacoes", informacaoService.obterLista());
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeSmartphones", smartphonesService.obterQtde());
		model.addAttribute("qtdeEletroportateis", eletroportateisService.obterQtde());

		return "home";
	}
}