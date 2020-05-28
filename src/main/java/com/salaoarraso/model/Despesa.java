package com.salaoarraso.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoDespesa;
	private double valor;
	private String tipoPagamento;
	private boolean statusPagamento;
	
	@ManyToMany()
    @JoinTable(
            name = "despesa_usuario",
            joinColumns = @JoinColumn(name="despesa_id"),
            inverseJoinColumns = @JoinColumn(name="usuario_id")
        )
	private List<Usuario> usuarios;
	
}
