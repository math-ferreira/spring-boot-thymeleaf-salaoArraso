package com.salaoarrazus.domain.model.enums;

public enum TipoTelefone {

	OUTROS(1),
	RESIDENCIAL(2),
	COMERCIAL(3),
	CELULAR(4);
	
	private Integer code;
	
	private TipoTelefone(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static TipoTelefone valueOf(Integer code) {
		for (TipoTelefone value : TipoTelefone.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo para Tipo Telefone invalido");
	}
}
