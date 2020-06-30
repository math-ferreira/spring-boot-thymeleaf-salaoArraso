package com.salaoarrazus.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
