package com.salaoarrazus.domain.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.domain.model.Produto;
import com.salaoarrazus.domain.model.enums.StatusCaixa;
import com.salaoarrazus.domain.model.enums.StatusPagamento;

import lombok.Data;

@Data
public class ProdutoDTO {

	private String descricaoProduto;
	private Integer quantidade;
	private double valor;
	private Date data;
	private StatusPagamento statusPagamento;
	private List<Fornecedor> fornecedores = new ArrayList<>();
	private StatusCaixa statusCaixa;
	
	
	public static ProdutoDTO create(Produto produto) {
		ModelMapper modelMapper = new ModelMapper();
		ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
		return produtoDTO;
	}
}
