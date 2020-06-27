package com.salaoarrazus.domain.dto;

import java.util.Date;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Servico;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.domain.model.enums.StatusPagamento;
import com.salaoarrazus.domain.model.enums.TipoAtendimento;

import lombok.Data;

@Data
public class ServicoDTO {

	private Long id;
	private int quantidadeSessoes;
	private TipoAtendimento tipoAtendimento;
	private double valorTotal;
	private StatusPagamento statusPagamento;
	private Date dataPedido;
	private Pessoa pessoa;
	
	
	public static ServicoDTO create(Servico atendimento) {
		ModelMapper modelMapper = new ModelMapper();
		ServicoDTO atendimentoDTO = modelMapper.map(atendimento, ServicoDTO.class);
		return atendimentoDTO;
		
	}
	
}
