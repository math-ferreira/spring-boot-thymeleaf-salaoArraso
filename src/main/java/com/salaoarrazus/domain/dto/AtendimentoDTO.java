package com.salaoarrazus.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

import com.salaoarrazus.domain.model.Atendimento;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.domain.model.enums.ModoPagamento;
import com.salaoarrazus.domain.model.enums.StatusPagamento;
import com.salaoarrazus.domain.model.enums.TipoAtendimento;

import lombok.Data;

@Data
public class AtendimentoDTO {

	private Long id;
	private LocalDateTime dataAtendimento;
	private BigDecimal valorAtendimento;
	private boolean atendimentoRealizado;
	private TipoAtendimento tipoAtendimento;
	private StatusPagamento statusPagamento;
	private ModoPagamento modoPagamento;
	private Pessoa pessoa;
	
	public static AtendimentoDTO create(Atendimento atendimento) {
		ModelMapper modelMapper = new ModelMapper();
		AtendimentoDTO atendimentosMarcadosDTO = modelMapper.map(atendimento, AtendimentoDTO.class);
		return atendimentosMarcadosDTO;
	}
}
