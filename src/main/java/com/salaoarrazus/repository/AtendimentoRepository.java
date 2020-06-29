package com.salaoarrazus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salaoarrazus.domain.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
	
}
