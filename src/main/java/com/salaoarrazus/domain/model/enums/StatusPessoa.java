package com.salaoarrazus.domain.model.enums;

public enum StatusPessoa {
	
	OUTROS(1),
	FUNCIONARIO(2),
	MANICURE(3),
	PEDICURE(4),
	CABELO(5);

	
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
