package com.salaoarraso.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String tipoFornecimento;
	
	@OneToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;
	
	@OneToMany(mappedBy = "fornecedores")
	private List<Endereco> enderecos;
	
	@ManyToMany(mappedBy = "fornecedores")
	private List<Produto> produtos;
	
}
