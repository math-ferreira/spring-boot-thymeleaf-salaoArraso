package com.salaoarrazus.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.domain.model.Produto;

import lombok.Data;

@Data
public class FornecedorDTO {

	private String nome;
	private String cnpj;
	private String ramo;
	private List<Contato> contatos = new ArrayList<>();
	private List<Produto> produtos = new ArrayList<>();
	private List<Endereco> enderecos = new ArrayList<>();
	
	public static FornecedorDTO create(Fornecedor fornecedor) {
		ModelMapper modelMapper = new ModelMapper();
		FornecedorDTO fornecedorDTO = modelMapper.map(fornecedor, FornecedorDTO.class);
		return fornecedorDTO;
	}

}
