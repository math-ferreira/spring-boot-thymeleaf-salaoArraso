package com.salaoarrazus.domain.model.enums;

public enum TipoServico {

	MANICURE(1),
	PEDICURE(2),
	CABELO(3),
	OUTROS(4);
	
	private Integer code;
	
	private TipoServico(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static TipoServico valueOf(Integer code) {
		for (TipoServico value : TipoServico.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo para Tipo Serviço invalido");
	}
}
