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

import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.service.PessoaService;

@Controller
@RequestMapping("/agenda/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	

	@GetMapping()
	public String agenda(ModelMap model) {
		model.addAttribute("pessoas", pessoaService.getPessoas());
		return "agenda/index-agenda-pessoas";
	}

	@GetMapping("/editar/{id}/pessoa")
	public ModelAndView editarPessoa(@PathVariable("id") Long id) {

		ModelAndView mvc = new ModelAndView("agenda/editar-agenda-pessoas");
		mvc.addObject("pessoa", pessoaService.getPessoaById(id));
		return mvc;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView adicionarPessoa(Pessoa pessoa) {
		ModelAndView mv = new ModelAndView("agenda/editar-agenda-pessoas");
		mv.addObject("pessoa", pessoa);
		return mv;
	}

	@PostMapping("/save")
	public String save(Pessoa pessoa, @RequestParam("pessoaId") Long id) {
		if (Objects.isNull(id)) {			
			pessoaService.postPessoa(pessoa);
		} else {
			pessoaService.putPessoa(pessoa, id);
		}
		return "redirect:";
	}
	
	@DeleteMapping("/remover/{id}/pessoa")
	public String delete(@PathVariable("id") Long id) {
		pessoaService.deletePessoa(id);
		return "redirect:/agenda/pessoas";
	}
}
