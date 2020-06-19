package com.salaoarrazus.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.service.PessoaService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView mvc = new ModelAndView("agenda/editar-agenda");
		mvc.addObject("pessoa", pessoaService.getPessoaById(id));
		return mvc;
	}
	
	@PostMapping("/save")
	public String save(Pessoa pessoa) {
		pessoaService.postPessoa(pessoa);
		return "index";
	}
	
}
