package com.salaoarrazus.domain.dto;

import java.util.Date;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Atendimento;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.domain.model.enums.StatusPagamento;
import com.salaoarrazus.domain.model.enums.TipoAtendimento;

import lombok.Data;

@Data
public class AtendimentoDTO {

	private Long id;
	private int quantidadeSessoes;
	private TipoAtendimento tipoAtendimento;
	private double valorTotal;
	private StatusPagamento statusPagamento;
	private Date dataPedido;
	private Pessoa pessoa;
	
	
	public static AtendimentoDTO create(Atendimento atendimento) {
		ModelMapper modelMapper = new ModelMapper();
		AtendimentoDTO atendimentoDTO = modelMapper.map(atendimento, AtendimentoDTO.class);
		return atendimentoDTO;
		
	}
	
}
