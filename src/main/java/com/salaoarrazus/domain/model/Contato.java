package com.salaoarrazus.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_contato")
public class Contato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	@JsonIgnore
	@ManyToOne
	@JoinTable(
			name = "tb_fornecedor_contato",
			joinColumns = @JoinColumn(name= "contato_id"),
			inverseJoinColumns = @JoinColumn(name="fornecedor_id")
			)
	private Fornecedor fornecedor;

	
	@OneToMany(mappedBy = "contato")
	private List<Telefone> telefones = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinTable(
			name = "tb_cliente_contato",
			joinColumns = @JoinColumn(name= "contato_id"),
			inverseJoinColumns = @JoinColumn(name="cliente_id")
			)
	private Cliente cliente;
	
	public Contato() {

	}

	public Contato(Long id, String email, Fornecedor fornecedor, Cliente cliente) {
		super();
		this.id = id;
		this.email = email;
		this.fornecedor = fornecedor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Telefone> getTelefones() {
		return telefones;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
