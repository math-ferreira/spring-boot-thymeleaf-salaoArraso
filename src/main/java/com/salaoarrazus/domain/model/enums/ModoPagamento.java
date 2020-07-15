package com.salaoarrazus.domain.model.enums;

public enum ModoPagamento {

	DINHEIRO_ESPECIE(1),
	CARTAO_CREDITO(2),
	CARTAO_DEBITO(3),
	CHEQUE(4),
	TRANSFERENCIA(5),
	OUTROS(6);
	
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
