package com.salaoarrazus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salaoarrazus.domain.dto.PessoaDTO;
import com.salaoarrazus.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping()
	public ResponseEntity<List<PessoaDTO>> getPessoas() {
		List<PessoaDTO> pessoas = pessoaService.getPessoas();
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> getPessoasById(@PathVariable("id") Long id ){
		PessoaDTO pessoa = pessoaService.getPessoaById(id);
		return ResponseEntity.ok(pessoa);
	}
}
