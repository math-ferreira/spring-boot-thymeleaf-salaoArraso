package com.salaoarrazus.domain.model.enums;

public enum StatusCaixa {

	ENTRADA(1),
	SAIDA(2),
	EMPRESTIMO(3),
	ENTRADA_ATRASADA(4),
	SAIDA_ATRASADA(5);
	
	private Integer code;
	
	private StatusCaixa(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static StatusCaixa valueOf(Integer code) {
		for (StatusCaixa value : StatusCaixa.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo para Status Caixa invalido");
	}
}
