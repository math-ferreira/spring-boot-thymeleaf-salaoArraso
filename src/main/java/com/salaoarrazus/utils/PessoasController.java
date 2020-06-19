package com.salaoarrazus.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salaoarrazus.domain.dto.PessoaDTO;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.service.PessoaService;

@Controller
@RequestMapping("/")
public class PessoasController {

	/*
	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/alterar")
	public ModelAndView alterar(PessoaDTO pessoa) {
		ModelAndView mv = new ModelAndView("contatos/adicionar-contato");
		if (!pessoa.getId().toString().equals(null)) {
			mv.addObject("pessoa", pessoa);
		}
		return mv;
	}
	

	@GetMapping("/alterar-contato.html")
	public String alterar(ModelMap model) {
		model.addAttribute("pessoas", pessoaService.getPessoas());
		return "contatos/alterar-contato";
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		return alterar(pessoaService.getPessoaById(id));
	}
	
	@PostMapping("/save")
	public String save(Pessoa pessoa) {
		pessoaService.postPessoa(pessoa);
		return "index";
	} */

}
