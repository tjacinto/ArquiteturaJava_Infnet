package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.SmartphonesService;

@Controller
public class SmartphonesController {

	@Autowired
	private AppController appController;

	@Autowired
	private SmartphonesService smartphonesService;

	@GetMapping(value = "/smartphones/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		smartphonesService.excluir(id);

		return "redirect:/smartphones/lista";
	}

	@GetMapping(value = "/smartphones/lista")
	public String obterLista(Model model) {
		model.addAttribute("rota", "smartphones");
		model.addAttribute("titulo", "Smartphones:");
		model.addAttribute("listagem", smartphonesService.obterLista());

		return appController.showHome(model);
	}
}