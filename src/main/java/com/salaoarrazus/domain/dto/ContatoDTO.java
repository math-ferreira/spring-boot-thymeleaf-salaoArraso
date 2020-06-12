package com.salaoarrazus.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Cliente;
import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.domain.model.Telefone;

import lombok.Data;

@Data
public class ContatoDTO {

	private String email;
	private Fornecedor fornecedor;
	private List<Telefone> telefones = new ArrayList<>();
	private Cliente cliente;
	
	public static ContatoDTO create(Contato contato) {
		ModelMapper modelMapper = new ModelMapper();
		ContatoDTO contatoDTO = modelMapper.map(contato, ContatoDTO.class);
		return contatoDTO;
	}
}
