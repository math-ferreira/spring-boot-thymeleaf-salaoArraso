package com.salaoarrazus.domain.model.enums;

public enum StatusPessoa {

	FUNCIONARIO(1),
	MANICURE(2),
	PEDICURE(3),
	CABELO(4),
	OUTROS(5);
	
	private Integer code;
	
	private StatusPessoa(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static StatusPessoa valueOf(Integer code) {
		for (StatusPessoa value : StatusPessoa.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo para Tipo Pessoa invalido");
	}
}
