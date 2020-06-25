package com.salaoarrazus.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.salaoarrazus.domain.model.enums.ModoPagamento;
import com.salaoarrazus.domain.model.enums.StatusPagamento;
import com.salaoarrazus.domain.model.enums.TipoAtendimento;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int quantidadeSessoes;
	private Integer tipoAtendimento = TipoAtendimento.OUTROS.getCode();
	private double valorTotal;
	private Integer statusPagamento = StatusPagamento.AGUARDANDO_PAGAMENTO.getCode();
	private Date dataPedido;
	private Integer modoPagamento = ModoPagamento.OUTROS.getCode();
	
	@ManyToOne()
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	public Atendimento() {
		
	}

	public Atendimento(Long id, int quantidadeSessoes, TipoAtendimento tipoAtendimento, double valorTotal,
			StatusPagamento statusPagamento, Date dataPedido, Pessoa pessoa, ModoPagamento modoPagamento) {
		super();
		this.id = id;
		this.quantidadeSessoes = quantidadeSessoes;
		setTipoAtendimento(tipoAtendimento);
		this.valorTotal = valorTotal;
		setStatusPagamento(statusPagamento);
		setModoPagamento(modoPagamento);
		this.dataPedido = dataPedido;
		this.pessoa = pessoa;
	}
	
	public ModoPagamento getModoPagamento() {
		return ModoPagamento.valueOf(modoPagamento);
	}

	public void setModoPagamento(ModoPagamento modoPagamento) {
		this.modoPagamento = modoPagamento.getCode();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidadeSessoes() {
		return quantidadeSessoes;
	}

	public void setQuantidadeSessoes(int quantidadeSessoes) {
		this.quantidadeSessoes = quantidadeSessoes;
	}

	public TipoAtendimento getTipoAtendimento() {
		return TipoAtendimento.valueOf(tipoAtendimento);
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento.getCode();
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPagamento getStatusPagamento() {
		return StatusPagamento.valueOf(statusPagamento);
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento.getCode();
	}
	
	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
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
		Atendimento other = (Atendimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
