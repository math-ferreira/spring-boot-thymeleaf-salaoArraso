package com.salaoarraso.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;
	
	@ManyToMany(mappedBy = "usuarios")
	private List<Despesa> despesas;

}
