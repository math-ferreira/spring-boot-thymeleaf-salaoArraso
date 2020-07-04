package com.salaoarrazus.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_atendimentos_marcados")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAtendimento;

	private BigDecimal valorAtendimento;
	private boolean atendimentoRealizado;
	private Integer tipoAtendimento = TipoAtendimento.OUTROS.getCode();
	private Integer statusPagamento = StatusPagamento.AGUARDANDO_PAGAMENTO.getCode();
	private Integer modoPagamento = ModoPagamento.OUTROS.getCode();

	@ManyToOne()
	@JoinColumn(name = "pessoa_fk")
	private Pessoa pessoa;

	public Atendimento() {

	}

	public Atendimento(Long id, LocalDateTime dataAtendimento, BigDecimal valorAtendimento, boolean atendimentoRealizado,
			TipoAtendimento tipoAtendimento, StatusPagamento statusPagamento, ModoPagamento modoPagamento,
			Pessoa pessoa) {
		super();
		this.id = id;
		this.dataAtendimento = dataAtendimento;
		this.valorAtendimento = valorAtendimento;
		this.atendimentoRealizado = atendimentoRealizado;
		setTipoAtendimento(tipoAtendimento);
		setStatusPagamento(statusPagamento);
		setModoPagamento(modoPagamento);
		this.pessoa = pessoa;
	}

	public boolean getAtendimentoRealizado() {
		return this.atendimentoRealizado;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
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

	public LocalDateTime getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(LocalDateTime dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public BigDecimal getValorAtendimento() {
		return valorAtendimento;
	}

	public void setValorAtendimento(BigDecimal valorAtendimento) {
		this.valorAtendimento = valorAtendimento;
	}

	public boolean isAtendimentoRealizado() {
		return atendimentoRealizado;
	}

	public void setAtendimentoRealizado(boolean atendimentoRealizado) {
		this.atendimentoRealizado = atendimentoRealizado;
	}

	public ModoPagamento getModoPagamento() {
		return ModoPagamento.valueOf(modoPagamento);
	}

	public void setModoPagamento(ModoPagamento modoPagamento) {
		this.modoPagamento = modoPagamento.getCode();
	}

	public TipoAtendimento getTipoAtendimento() {
		return TipoAtendimento.valueOf(tipoAtendimento);
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento.getCode();
	}

	public StatusPagamento getStatusPagamento() {
		return StatusPagamento.valueOf(statusPagamento);
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento.getCode();
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
