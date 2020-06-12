package com.salaoarrazus.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.domain.model.Funcionario;

import lombok.Data;

@Data
public class FuncionarioDTO {

	private String nome;
	private Integer tipoServico;
	private List<Endereco> enderecos = new ArrayList<>();
	
	public static FuncionarioDTO create(Funcionario funcionario) {
		ModelMapper modelMapper = new ModelMapper();
		FuncionarioDTO funcionarioDTO = modelMapper.map(funcionario, FuncionarioDTO.class);
		return funcionarioDTO;
	}
}
