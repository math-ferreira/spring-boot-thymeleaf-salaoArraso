package com.salaoarrazus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salaoarrazus.domain.dto.ClienteDTO;
import com.salaoarrazus.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping()
	public ResponseEntity<List<ClienteDTO>> getClientes() {
		List<ClienteDTO> clientes = clienteService.getClientes();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> getClienteById(@PathVariable("id") Long id ){
		ClienteDTO cliente = clienteService.getClienteById(id);
		return ResponseEntity.ok(cliente);
	}
}
