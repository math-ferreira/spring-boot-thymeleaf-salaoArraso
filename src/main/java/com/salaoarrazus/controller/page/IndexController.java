package com.salaoarrazus.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salaoarrazus.service.PessoaService;

@Controller
@RequestMapping()
public class IndexController {
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/") public String index() { return "index";}
	
	@GetMapping("/atendimentos") public String atendimentos() {return "calendario-atendimentos/atendimentos-hoje";}
	
	@GetMapping("/calendario") public String calendario() { return "calendario-atendimentos/consultar-calendario";}
	
	@GetMapping("/agenda")
	public String agenda(ModelMap model) {
		model.addAttribute("pessoas", pessoaService.getPessoas());
		return "agenda/index-agenda";
	}
	
	@GetMapping("/caixa") public String caixa() { return "fluxo-de-caixa/index-fluxo-de-caixa";}
	
	@GetMapping("/servicos") public String servicos() { return "servicos/index-servicos"; }
	 
}
