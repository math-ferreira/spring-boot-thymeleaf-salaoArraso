package com.salaoarrazus.controller.page;

import com.salaoarrazus.domain.model.Atendimento;
import com.salaoarrazus.service.ProdutoService;

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

@Controller
@RequestMapping("/organizacao/estoque")
public class EstoqueController {

	@Autowired
	private ProdutoService ProdutoService;

	@GetMapping()
	public String estoque(ModelMap model) throws Exception {
		model.addAttribute("produtos", ProdutoService.getProdutos());
		return "organizacao/estoque";
	}

	@GetMapping("/editar/{id}/estoque")
	public ModelAndView editarEstoque(@PathVariable("id") Long id) {
		return null;
	}

	@GetMapping("/adicionar")
	public ModelAndView adicionarEstoque(Atendimento atendimento) {
		return null;
	}

	@PostMapping("/save")
	public String save(Atendimento atendimento, @RequestParam("estoqueId") Long id) {
		return null;
	}

	@DeleteMapping("/remover/{id}/estoque")
	public String delete(@PathVariable("id") Long id) {
		return null;
	}
	
}
