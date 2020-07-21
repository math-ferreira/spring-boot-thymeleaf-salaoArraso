package com.salaoarrazus.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class IndexController {

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mvc = new ModelAndView("index.html");
		return mvc;
	}

	@GetMapping("/atendimentos")
	public ModelAndView atendimentos() {
		ModelAndView mvc = new ModelAndView("calendario-atendimentos/atendimentos-hoje.html");
		return mvc;
	}

	@GetMapping("/caixa")
	public ModelAndView caixa() {
		ModelAndView mvc = new ModelAndView("fluxo-de-caixa/index-fluxo-de-caixa.html");
		return mvc;
	}

	@GetMapping("/servicos")
	public ModelAndView servicos() {
		ModelAndView mvc = new ModelAndView("servicos/index-servicos.html");
		return mvc;
	}

}
