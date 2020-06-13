package com.salaoarrazus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salaoarrazus.domain.dto.ContatoDTO;
import com.salaoarrazus.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@GetMapping()
	public ResponseEntity<List<ContatoDTO>> getContatos() {
		List<ContatoDTO> contatos = contatoService.getContatos();
		return ResponseEntity.ok(contatos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContatoDTO> getCarro(@PathVariable("id") Long id) {
		ContatoDTO contato = contatoService.getContato(id);
		return ResponseEntity.ok(contato);
	}

}
