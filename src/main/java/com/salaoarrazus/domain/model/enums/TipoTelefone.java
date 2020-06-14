package com.salaoarrazus.domain.model.enums;

public enum TipoTelefone {

	RESIDENCIAL(1),
	COMERCIAL(2),
	CELULAR(3),
	OUTROS(4);
	
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
