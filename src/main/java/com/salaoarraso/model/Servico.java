package com.salaoarraso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Servico {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nomeServico;
	private double valorServico;
	
	
}
