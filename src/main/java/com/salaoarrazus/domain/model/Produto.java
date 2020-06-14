package com.salaoarrazus.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salaoarrazus.domain.model.enums.StatusCaixa;
import com.salaoarrazus.domain.model.enums.StatusPagamento;

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
	private double valor;
	private Date data;
	private Integer statusPagamento;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "tb_produto_fornecedor",
			joinColumns = @JoinColumn(name= "produto_id"),
			inverseJoinColumns = @JoinColumn(name="fornecedor_id")
			)
	private List<Fornecedor> fornecedores = new ArrayList<>();
	
	private Integer statusCaixa;

	public Produto() {

	}

	public Produto(Long id, String descricaoProduto, Integer quantidade, double valor, Date data,
			StatusPagamento statusPagamento, StatusCaixa statusCaixa) {
		super();
		this.id = id;
		this.descricaoProduto = descricaoProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.data = data;
		setStatusPagamento(statusPagamento);
		setStatusCaixa(statusCaixa);
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
