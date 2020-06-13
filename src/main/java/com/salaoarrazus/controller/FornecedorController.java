package com.salaoarrazus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salaoarrazus.domain.dto.FornecedorDTO;
import com.salaoarrazus.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping()
	public ResponseEntity<List<FornecedorDTO>> getFornecedores() {
		List<FornecedorDTO> fornecedores = fornecedorService.getFornecedores();
		return ResponseEntity.ok(fornecedores);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FornecedorDTO> getFornecedor(@PathVariable("id") Long id) {
		FornecedorDTO fornecedor = fornecedorService.getFornecedorById(id);
		return ResponseEntity.ok(fornecedor);

	}
}
