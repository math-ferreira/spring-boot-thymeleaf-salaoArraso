package com.salaoarrazus.domain.dto;

import org.modelmapper.ModelMapper;

import java.util.List;

import com.salaoarrazus.domain.model.Atendimento;
import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.domain.model.Pessoa;

import lombok.Data;

@Data
public class PessoaDTO {
	
	private Long id;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	private List<Atendimento> atendimentos;
	
	public static PessoaDTO create(Pessoa pessoa) {
		ModelMapper modelMapper = new ModelMapper();
		PessoaDTO pessoaDTO = modelMapper.map(pessoa, PessoaDTO.class);
		return pessoaDTO;
	}
}
