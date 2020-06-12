package com.salaoarrazus.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Cliente;
import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Endereco;

import lombok.Data;

@Data
public class ClienteDTO {

	private String nome;
	private Endereco endereco;
	private List<Contato> contatos = new ArrayList<>();
	
	public static ClienteDTO create(Cliente cliente) {
		ModelMapper modelMapper = new ModelMapper();
		ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
		return clienteDTO;
	}
	
}
