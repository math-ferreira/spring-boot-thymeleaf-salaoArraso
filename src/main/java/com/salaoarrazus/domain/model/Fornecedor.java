package com.salaoarrazus.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cnpj;
	private String ramo;

	@OneToMany(mappedBy = "fornecedor")
	private List<Contato> contatos = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "fornecedores")
	private List<Produto> produtos = new ArrayList<>();

	@OneToMany(mappedBy = "fornecedor")
	private List<Endereco> enderecos = new ArrayList<>();

	public Fornecedor() {

	}

	public Fornecedor(Long id, String nome, String cnpj, String ramo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.ramo = ramo;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Contato> getContatos() {
		return contatos;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
