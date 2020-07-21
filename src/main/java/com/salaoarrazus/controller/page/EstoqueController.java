package com.salaoarrazus.controller.page;

import java.util.List;
import java.util.Objects;

import com.salaoarrazus.SalaoArrazusApplication;
import com.salaoarrazus.domain.dto.ProdutoDTO;
import com.salaoarrazus.domain.model.Produto;
import com.salaoarrazus.service.FornecedorService;
import com.salaoarrazus.service.ProdutoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static Logger logger = LoggerFactory.getLogger(SalaoArrazusApplication.class);
	
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping()
	public String estoque(ModelMap model) throws Exception {
		logger.info("# Pagina inicial de itens");
		List<ProdutoDTO> produtos = produtoService.getProdutos();
		model.addAttribute("produtos", produtoService.converteDataGTMLocal(produtos));
		return "organizacao/index-estoque.html";
	}

	@GetMapping("/editar/{id}/produtos")
	public ModelAndView editarEstoque(@PathVariable("id") Long id) {
		logger.info("# Pagina editar item com id: " + id);
		ModelAndView mvc = new ModelAndView("organizacao/editar-estoque-produtos.html");
		mvc.addObject("produto", produtoService.getProdutoById(id));
		mvc.addObject("fornecedores", fornecedorService.getFornecedores());
		return mvc;
	}

	@GetMapping("/adicionar")
	public ModelAndView adicionarEstoque(Produto produto) {
		logger.info("# Pagina adicionar novo item");
		ModelAndView mvc = new ModelAndView("organizacao/editar-estoque-produtos.html");
		mvc.addObject("produto", produto);
		mvc.addObject("fornecedores", fornecedorService.getFornecedores());
		return mvc;
	}

	@PostMapping("/save")
	public String save(Produto produto, @RequestParam("produtoId") Long id) {
		if (Objects.isNull(id)) {
			logger.info("# Inserindo novo item com body: " + produto.toString());
			produtoService.postProduto(produto);
		} else {
			logger.info("# Atualizando item com id: " + id);
			produtoService.putProduto(produto, id);
		}
		return "redirect:";
	}

	@DeleteMapping("/remover/{id}/produto")
	public String delete(@PathVariable("id") Long id) {
		logger.info("# Removendo item com id: " + id);
		produtoService.deleteProduto(id);
		return "redirect:http://localhost:8080/salao_arrazus/v1/organizacao/estoque";
	}
	
}
