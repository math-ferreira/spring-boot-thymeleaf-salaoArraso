package com.salaoarraso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rua;
	private String bairro;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	
	@ManyToOne()
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedores;
}
