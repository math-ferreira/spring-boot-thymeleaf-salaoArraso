package com.salaoarrazus.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salaoarrazus.domain.model.enums.StatusCaixa;
import com.salaoarrazus.domain.model.enums.StatusPagamento;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricaoProduto;
	private Integer quantidade;
	private BigDecimal valor;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime data;
	
	private Integer statusPagamento = StatusPagamento.AGUARDANDO_PAGAMENTO.getCode();

	@ManyToOne()
	@JoinColumn(name = "fornecedor_fk")
	private Fornecedor fornecedor;
	
	private Integer statusCaixa = StatusCaixa.ENTRADA.getCode();

	public Produto() {

	}

	public Produto(Long id, String descricaoProduto, Integer quantidade, BigDecimal valor, LocalDateTime data,
			StatusPagamento statusPagamento, StatusCaixa statusCaixa, Fornecedor fornecedor) {
		super();
		this.id = id;
		this.descricaoProduto = descricaoProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.data = data;
		setStatusPagamento(statusPagamento);
		setStatusCaixa(statusCaixa);
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public StatusPagamento getStatusPagamento() {
		return StatusPagamento.valueOf(statusPagamento);
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento.getCode();
	}
	
	public StatusCaixa getStatusCaixa() {
		return StatusCaixa.valueOf(statusCaixa);
	}

	public void setStatusCaixa(StatusCaixa statusCaixa) {
		this.statusCaixa = statusCaixa.getCode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
