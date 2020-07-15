package com.salaoarrazus.domain.model.enums;

public enum TipoAtendimento {
	
	OUTROS(1),
	MANICURE(2),
	PEDICURE(3),
	CORTE_CABELO(4),
	COLORAÇÃO_CABELO(5),
	MASSAGEM_CABELO(6),
	LUZES_CABELO(7),
	ESCOVA_CABELO(8),
	PROGRESSIVA_CABELO(9),
	PENTEADO_CABELO(10),
	DEPILACAO(11),
	ESTETICA_FACIAL(12),
	ESTETICA_CORPORAL(13),
	MAQUIAGEM(14),
	SOBRANCELHAS(15),
	PRODUCAO_COMPLETA(16),
	HIDRATACAO(17),
	BARBA(18);

	private Integer code;
	
	private TipoAtendimento(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static TipoAtendimento valueOf(Integer code) {
		for (TipoAtendimento value : TipoAtendimento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo para Tipo Atendimento invalido");
	}
}
