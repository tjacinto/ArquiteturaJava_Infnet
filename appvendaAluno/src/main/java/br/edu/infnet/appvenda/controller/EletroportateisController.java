package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.EletroportateisService;

@Controller
public class EletroportateisController {

	@Autowired
	private AppController appController;

	@Autowired
	private EletroportateisService eletroportateisService;

	@GetMapping(value = "/eletroportateis/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		eletroportateisService.excluir(id);

		return "redirect:/eletroportateis/lista";
	}

	@GetMapping(value = "/eletroportateis/lista")
	public String obterLista(Model model) {

		model.addAttribute("rota", "eletroportateis");
		model.addAttribute("titulo", "Eletroportateis:");
		model.addAttribute("listagem", eletroportateisService.obterLista());

		return appController.showHome(model);
	}
}