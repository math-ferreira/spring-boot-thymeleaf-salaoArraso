package com.salaoarrazus.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {


	@GetMapping("/") public String index() { return "index";}
	
	@GetMapping("/atendimentos") public String atendimentos() {return "calendario-atendimentos/atendimentos-hoje";}
	
	@GetMapping("/calendario") public String calendario() { return "calendario-atendimentos/consultar-calendario";}
	
	@GetMapping("/caixa") public String caixa() { return "fluxo-de-caixa/index-fluxo-de-caixa";}
	
	@GetMapping("/servicos") public String servicos() { return "servicos/index-servicos"; }

}
