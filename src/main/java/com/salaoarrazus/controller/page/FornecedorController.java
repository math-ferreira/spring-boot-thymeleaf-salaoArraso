package com.salaoarrazus.controller.page;

import java.util.Objects;

import com.salaoarrazus.SalaoArrazusApplication;
import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.service.FornecedorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/agenda/fornecedores")
public class FornecedorController {
	
	@Value("${url.domain}")
	private String domainURL;
	
	@Value("${server.servlet.context-path}")
	private String pathURL;
	
	private static Logger logger = LoggerFactory.getLogger(SalaoArrazusApplication.class);
	
	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping()
	public String agenda(ModelMap model) {
		logger.info("# Pagina inicial de contatos fornecedores");
		model.addAttribute("fornecedores", fornecedorService.getFornecedores());
		return "agenda/index-agenda-fornecedores.html";
	}
	
	@GetMapping("/editar/{id}/fornecedor")
	public ModelAndView editarFornecedor(@PathVariable("id") Long id) {
		logger.info("# Pagina editar fornecedor com id: " + id);
		ModelAndView mvc = new ModelAndView("agenda/editar-agenda-fornecedores.html");
		mvc.addObject("fornecedor", fornecedorService.getFornecedorById(id));
		return mvc;
	}

	@GetMapping("/adicionar")
	public ModelAndView adicionarFornecedor(Fornecedor fornecedor) {
		logger.info("# Pagina adicionar novo fornecedor");
		ModelAndView mv = new ModelAndView("agenda/editar-agenda-fornecedores.html");
		mv.addObject("fornecedor", fornecedor);
		return mv;
	}

	@PostMapping("/save")
	public String save(Fornecedor fornecedor, @RequestParam("fornecedorId") Long id) {
		if (Objects.isNull(id)) {
			logger.info("# Inserindo novo fornecedor com body: " + fornecedor.toString());			
			fornecedorService.postFornecedor(fornecedor);
		} else {
			logger.info("# Atualizando fornecedor com id: " + id);
			fornecedorService.putFornecedor(fornecedor, id);
		}
		return "redirect:";
	}
	
	@DeleteMapping("/remover/{id}/fornecedor")
	public String delete(@PathVariable("id") Long id) {
		logger.info("# Removendo fornecedor com id: " + id);
		fornecedorService.deleteFornecedor(id);
		return "redirect:" + domainURL + pathURL + "/agenda/fornecedores";
	}
}
