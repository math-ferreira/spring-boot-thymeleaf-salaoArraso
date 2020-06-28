package com.salaoarrazus.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salaoarrazus.service.AtendimentoService;
import com.salaoarrazus.service.config.PeriodicidadeAtendimentos;

@Controller
@RequestMapping("/calendario/servicos")
public class CalendarioServicosController {

	
	@Autowired
	private AtendimentoService atendimentoService;
	

	@GetMapping()
	public String agenda(ModelMap model) throws Exception{
		model.addAttribute("atendimentosSemanais", atendimentoService.getAtendimentos(PeriodicidadeAtendimentos.SEMANAL));
		model.addAttribute("atendimentosMensais", atendimentoService.getAtendimentos(PeriodicidadeAtendimentos.MENSAL));
		return "calendario-atendimentos-servicos/index-calendario-servicos.html";
	}
}
