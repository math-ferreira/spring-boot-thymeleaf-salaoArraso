package com.salaoarrazus.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.domain.model.Produto;
import com.salaoarrazus.domain.model.enums.StatusCaixa;
import com.salaoarrazus.domain.model.enums.StatusPagamento;

import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProdutoDTO {

	private Long id;
	private String descricaoProduto;
	private Integer quantidade;
	private BigDecimal valor;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime data;
	
	private StatusPagamento statusPagamento;
	private Fornecedor fornecedor;
	private StatusCaixa statusCaixa;
	
	
	public static ProdutoDTO create(Produto produto) {
		ModelMapper modelMapper = new ModelMapper();
		ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
		return produtoDTO;
	}
}
