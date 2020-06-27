package com.salaoarrazus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salaoarrazus.domain.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
