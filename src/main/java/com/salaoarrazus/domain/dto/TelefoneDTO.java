package com.salaoarrazus.domain.dto;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Telefone;
import com.salaoarrazus.domain.model.enums.TipoTelefone;

import lombok.Data;

@Data
public class TelefoneDTO {

	private TipoTelefone tipoTelefone;
	private String numeroTelefone;
	
	public static TelefoneDTO create(Telefone telefone) {
		ModelMapper modelMapper = new ModelMapper();
		TelefoneDTO telefoneDTO = modelMapper.map(telefone, TelefoneDTO.class);
		return telefoneDTO;
	}

}
