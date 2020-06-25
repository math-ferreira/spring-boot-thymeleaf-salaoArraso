package com.salaoarrazus.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salaoarrazus.service.AtendimentoService;

@Controller
@RequestMapping("/calendario/servicos")
public class CalendarioServicosController {

	
	@Autowired
	private AtendimentoService atendimentoService;
	

	@GetMapping()
	public String agenda(ModelMap model) {
		model.addAttribute("atendimentos", atendimentoService.getAtendimentos());
		return "calendario-atendimentos-servicos/index-calendario-servicos.html";
	}
}
