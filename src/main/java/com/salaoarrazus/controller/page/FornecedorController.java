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

import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.service.FornecedorService;

@Controller
@RequestMapping("/agenda/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping()
	public String agenda(ModelMap model) {
		model.addAttribute("fornecedores", fornecedorService.getFornecedores());
		return "agenda/index-agenda-fornecedores";
	}
	
	@GetMapping("/editar/{id}/fornecedor")
	public ModelAndView editarFornecedor(@PathVariable("id") Long id) {
		ModelAndView mvc = new ModelAndView("agenda/editar-agenda-fornecedores");
		mvc.addObject("fornecedor", fornecedorService.getFornecedorById(id));
		return mvc;
	}

	@GetMapping("/adicionar")
	public ModelAndView adicionarFornecedor(Fornecedor fornecedor) {
		ModelAndView mv = new ModelAndView("agenda/editar-agenda-fornecedores");
		mv.addObject("fornecedor", fornecedor);
		return mv;
	}

	@PostMapping("/save")
	public String save(Fornecedor fornecedor, @RequestParam("fornecedorId") Long id) {
		if (Objects.isNull(id)) {			
			fornecedorService.postFornecedor(fornecedor);
		} else {
			fornecedorService.putFornecedor(fornecedor, id);
		}
		return "redirect:";
	}
	
	@DeleteMapping("/remover/{id}/fornecedor")
	public String delete(@PathVariable("id") Long id) {
		fornecedorService.deleteFornecedor(id);
		return "redirect:/agenda/fornecedores";
	}
}
