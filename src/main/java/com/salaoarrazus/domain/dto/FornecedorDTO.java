package com.salaoarrazus.domain.dto;

import org.modelmapper.ModelMapper;
import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.domain.model.Fornecedor;

import lombok.Data;

@Data
public class FornecedorDTO {

	private String nome;
	private String cnpj;
	private String ramo;
	private Contato contato;
	private Endereco endereco;
	
	public static FornecedorDTO create(Fornecedor fornecedor) {
		ModelMapper modelMapper = new ModelMapper();
		FornecedorDTO fornecedorDTO = modelMapper.map(fornecedor, FornecedorDTO.class);
		return fornecedorDTO;
	}

}
