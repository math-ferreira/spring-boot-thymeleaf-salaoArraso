package com.salaoarraso.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	
	@OneToMany(mappedBy = "contato")
	private List<Telefone> telefones;
	
	@OneToOne(mappedBy = "contato")
	private Usuario usuario;
	
	@OneToOne(mappedBy = "contato")
	private Fornecedor fornecedor;
	
}

