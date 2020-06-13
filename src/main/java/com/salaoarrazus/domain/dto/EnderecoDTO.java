package com.salaoarrazus.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.domain.model.Pessoa;

import lombok.Data;

@Data
public class EnderecoDTO {

	private String rua;
	private String bairro;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	private Fornecedor fornecedor;
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public static EnderecoDTO create(Endereco endereco) {
		ModelMapper modelMapper = new ModelMapper();
		EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
		return enderecoDTO;
	}
	
}
