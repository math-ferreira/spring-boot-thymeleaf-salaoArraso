package com.salaoarrazus.controller.page;

import java.util.Objects;

import com.salaoarrazus.domain.model.Produto;
import com.salaoarrazus.domain.model.enums.StatusCaixa;
import com.salaoarrazus.service.FornecedorService;
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
	private ProdutoService produtoService;

	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping()
	public String estoque(ModelMap model) throws Exception {
		model.addAttribute("produtos", produtoService.getProdutos());
		return "organizacao/index-estoque";
	}

	@GetMapping("/editar/{id}/produtos")
	public ModelAndView editarEstoque(@PathVariable("id") Long id) {
		ModelAndView mvc = new ModelAndView("organizacao/editar-estoque-produtos");
		mvc.addObject("produto", produtoService.getProdutoById(id));
		mvc.addObject("fornecedores", fornecedorService.getFornecedores());
		return mvc;
	}

	@GetMapping("/adicionar")
	public ModelAndView adicionarEstoque(Produto produto) {
		ModelAndView mvc = new ModelAndView("organizacao/editar-estoque-produtos");
		mvc.addObject("produto", produto);
		mvc.addObject("fornecedores", fornecedorService.getFornecedores());
		return mvc;
	}

	@PostMapping("/save")
	public String save(Produto produto, @RequestParam("produtoId") Long id) {
		if (Objects.isNull(id)) {
			produtoService.postProduto(produto);
		} else {
			produtoService.putProduto(produto, id);
		}
		return "redirect:";
	}

	@DeleteMapping("/remover/{id}/produto")
	public String delete(@PathVariable("id") Long id) {
		produtoService.deleteProduto(id);
		return "redirect:/organizacao/estoque";
	}
	
}