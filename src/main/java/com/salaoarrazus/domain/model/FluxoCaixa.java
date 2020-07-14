package com.salaoarrazus.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FluxoCaixa {
    private String descricao;
    private LocalDateTime data;
    private BigDecimal valor;
}