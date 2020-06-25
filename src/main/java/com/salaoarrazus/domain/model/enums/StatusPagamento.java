package com.salaoarrazus.domain.model.enums;

public enum StatusPagamento {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	CANCELADO(3),
	PAGO_PARCIAL(4);
	
	private Integer code;
	
	private StatusPagamento(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static StatusPagamento valueOf(Integer code) {
		for (StatusPagamento value : StatusPagamento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo para Status Pagamento invalido");
	}
}
