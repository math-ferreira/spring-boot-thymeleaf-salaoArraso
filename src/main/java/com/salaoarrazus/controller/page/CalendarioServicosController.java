package com.salaoarrazus.controller.page;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.salaoarrazus.domain.model.Atendimento;
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
	
	
	@GetMapping("/editar/{id}/servicos")
	public ModelAndView editarPessoa(@PathVariable("id") Long id) {
		ModelAndView mvc = new ModelAndView("calendario-atendimentos-servicos/editar-calendario-servicos");
		mvc.addObject("atendimento", atendimentoService.getAtendimentoById(id));
		return mvc;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView adicionarPessoa(Atendimento atendimento) {
		ModelAndView mv = new ModelAndView("calendario-atendimentos-servicos/editar-calendario-servicos");
		mv.addObject("atendimento", atendimento);
		return mv;
	}
	
	@PostMapping("/save")
	public String save(Atendimento atendimento, @RequestParam("atendimentoId") Long id) {
		if (Objects.isNull(id)) {			
			atendimentoService.postAtendimento(atendimento);
		} else {
			atendimentoService.putAtendimento(atendimento, id);
		}
		return "redirect:";
	}
	
	@DeleteMapping("/remover/{id}/servico")
	public String delete(@PathVariable("id") Long id) {
		atendimentoService.deleteAtendimento(id);
		return "redirect:/agenda/pessoas";
	}
}
