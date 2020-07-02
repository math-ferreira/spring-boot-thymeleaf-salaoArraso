package com.salaoarrazus.service.config;

public enum PeriodicidadeAtendimentosEnum {

	TODOS(1),
	DIARIO(2),
	SEMANAL(3),
	MENSAL(4),
	ANUAL(5),
	FINALIZADOS(6);
	
	private Integer code;

	public Integer getCode() {
		return code;
	}
	
	private PeriodicidadeAtendimentosEnum(Integer code) {
		this.code = code;
	}
	
	public static PeriodicidadeAtendimentosEnum valueOf(Integer code) {
		for (PeriodicidadeAtendimentosEnum value : PeriodicidadeAtendimentosEnum.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo para Periodicidade de Atendimentos invalido");
	}
	
}
