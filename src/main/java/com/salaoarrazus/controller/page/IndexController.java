package com.salaoarrazus.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {

	@GetMapping("/index.html") public String index() { return "index";}
	
	@GetMapping("/atendimentos-hoje.html") public String atendimentos() {return "calendario-atendimentos/atendimentos-hoje";}
	
	@GetMapping("/consultar-calendario.html") public String calendario() { return "calendario-atendimentos/consultar-calendario";}
	
	@GetMapping("/contatos.html") public String contatos() { return "contatos/contatos";}
	
	@GetMapping("/fluxo-de-caixa.html") public String caixa() { return "fluxo-de-caixa/fluxo-de-caixa";}
	
	@GetMapping("/servicos.html") public String servicos() { return "servicos/servicos"; }
	 
}
