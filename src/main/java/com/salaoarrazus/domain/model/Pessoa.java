package com.salaoarrazus.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.salaoarrazus.domain.model.enums.StatusPessoa;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Integer statusPessoa;

	@ManyToOne()
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne()
	@JoinColumn(name = "contato_id")
	private Contato contato;

	public Pessoa() {

	}

	public Pessoa(Long id, String nome, StatusPessoa statusPessoa, Endereco endereco, Contato contato) {
		super();
		this.id = id;
		this.nome = nome;
		setStatusPessoa(statusPessoa);
		this.endereco = endereco;
		this.contato = contato;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEnderecos() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusPessoa getStatusPessoa() {
		return StatusPessoa.valueOf(statusPessoa);
	}

	public void setStatusPessoa(StatusPessoa statusPessoa) {
		this.statusPessoa = statusPessoa.getCode();
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
