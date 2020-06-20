package com.salaoarrazus.domain.dto;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Contato;

import lombok.Data;

@Data
public class ContatoDTO {
	
	private Long id;
	private String email;
	
	public static ContatoDTO create(Contato contato) {
		ModelMapper modelMapper = new ModelMapper();
		ContatoDTO contatoDTO = modelMapper.map(contato, ContatoDTO.class);
		return contatoDTO;
	}
}
