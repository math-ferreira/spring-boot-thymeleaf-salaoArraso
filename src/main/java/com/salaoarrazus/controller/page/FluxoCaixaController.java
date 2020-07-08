package com.salaoarrazus.controller.page;

import com.salaoarrazus.service.AtendimentoService;
import com.salaoarrazus.service.ProdutoService;
import com.salaoarrazus.service.config.PeriodicidadeAtendimentosEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizacao/fluxo-caixa")
public class FluxoCaixaController {

	@Autowired
	ProdutoService produtoService;

	@Autowired
	AtendimentoService atendimentoService;

	@GetMapping()
	public String fluxo(ModelMap model) throws Exception {
		model.addAttribute("atendimentos", atendimentoService.getAtendimentos(PeriodicidadeAtendimentosEnum.TODOS));
		model.addAttribute("itens", produtoService.getProdutos());
		return "organizacao/index-fluxo-de-caixa";
	}
	
}
