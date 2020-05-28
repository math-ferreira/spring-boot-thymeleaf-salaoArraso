package com.salaoarraso.model;

import java.util.Date;
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
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private Integer quantidade;
	private double valor;
	private Date dataCompra;
	
	@ManyToMany
    @JoinTable(
            name = "produto_despesa",
            joinColumns = @JoinColumn(name="produto_id"),
            inverseJoinColumns = @JoinColumn(name="fornecedor_id")
        )
	private List<Fornecedor> fornecedores;
	
}
