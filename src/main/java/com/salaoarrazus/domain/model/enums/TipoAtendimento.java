package com.salaoarrazus.domain.model.enums;

public enum TipoAtendimento {
	
	OUTROS(1),
	MANICURE(2),
	PEDICURE(3),
	CABELO(4);

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
