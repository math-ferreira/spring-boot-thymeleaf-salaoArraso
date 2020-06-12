package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.ClienteDTO;
import com.salaoarrazus.domain.model.Cliente;
import com.salaoarrazus.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDTO> getClientes(){
		List<Cliente> clientes = clienteRepository.findAll();
		
		List<ClienteDTO> clientesDTO = new ArrayList<>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(ClienteDTO.create(cliente));
		}
		return clientesDTO;
	}
	
	public ClienteDTO getClienteById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return ClienteDTO.create(cliente.get());
	}
}
