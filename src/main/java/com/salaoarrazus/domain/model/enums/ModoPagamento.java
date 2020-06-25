package com.salaoarrazus.domain.model.enums;

public enum ModoPagamento {

	DINHEIRO_ESPECIE(1),
	CARTAO(2),
	CHEQUE(3),
	OUTROS(4);
	
	private Integer code;
	
	private ModoPagamento(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static ModoPagamento valueOf(Integer code) {
		for (ModoPagamento value : ModoPagamento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo para Modo de Pagamento invalido");
	}
}
