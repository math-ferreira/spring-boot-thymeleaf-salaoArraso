package com.salaoarrazus.domain.dto;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Telefone;

import lombok.Data;

@Data
public class TelefoneDTO {

	private Integer tipoTelefone;
	private String numeroTelefone;
	private Contato contato;
	
	public static TelefoneDTO create(Telefone telefone) {
		ModelMapper modelMapper = new ModelMapper();
		TelefoneDTO telefoneDTO = modelMapper.map(telefone, TelefoneDTO.class);
		return telefoneDTO;
	}

}
