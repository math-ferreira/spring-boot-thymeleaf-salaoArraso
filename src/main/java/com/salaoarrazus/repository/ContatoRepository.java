package com.salaoarrazus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salaoarrazus.domain.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
