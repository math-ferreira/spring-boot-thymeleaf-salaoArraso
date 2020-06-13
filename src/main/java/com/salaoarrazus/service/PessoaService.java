package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.PessoaDTO;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<PessoaDTO> getPessoa(){
		List<Pessoa> pessoas = pessoaRepository.findAll();
		
		List<PessoaDTO> pessoasDTO = new ArrayList<>();
		for (Pessoa pessoa : pessoas) {
			pessoasDTO.add(PessoaDTO.create(pessoa));
		}
		return pessoasDTO;
	}
	
	public PessoaDTO getPessoaById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return PessoaDTO.create(pessoa.get());
	}
}
