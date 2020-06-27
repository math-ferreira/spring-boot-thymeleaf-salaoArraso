package com.salaoarrazus.domain.dto;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.domain.model.Servico;

import lombok.Data;

@Data
public class PessoaDTO {
	
	private Long id;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	private Servico servico;
	
	public static PessoaDTO create(Pessoa pessoa) {
		ModelMapper modelMapper = new ModelMapper();
		PessoaDTO pessoaDTO = modelMapper.map(pessoa, PessoaDTO.class);
		return pessoaDTO;
	}
}
