package com.salaoarrazus.controller.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salaoarrazus.domain.dto.PessoaDTO;
import com.salaoarrazus.service.PessoaService;

@Controller
@RequestMapping("/")
public class PessoasController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/adicionar-contato.html") public String adicionar() { return "contatos/adicionar-contato";}
	
	@GetMapping("/alterar-contato.html") public String alterar() { return "contatos/alterar-contato";}
	
	@GetMapping("/remover-contato.html") public String remover() { return "contatos/remover-contato";}
	
	@GetMapping("/contato-telefone.html") public String getAlterarContatoTelefonico() { return "contatos/alterar/contato-telefone";}
	
	@GetMapping("/busca-pessoas")
	public ModelAndView getPessoas() {
		List<PessoaDTO> pessoas = pessoaService.getPessoas();
		ModelAndView mav = new ModelAndView("busca-pessoas");
		mav.addObject(pessoas);
		return mav;
	}

}
