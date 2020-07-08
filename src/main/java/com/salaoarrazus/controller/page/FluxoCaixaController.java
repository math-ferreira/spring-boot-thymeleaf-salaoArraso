package com.salaoarrazus.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizacao/fluxo-caixa")
public class FluxoCaixaController {


	@GetMapping()
	public String fluxo(ModelMap model) throws Exception {
		return "organizacao/index-fluxo-de-caixa";
	}
	
}
