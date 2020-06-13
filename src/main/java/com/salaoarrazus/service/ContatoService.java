package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.ContatoDTO;
import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	public List<ContatoDTO> getContatos() {
		List<Contato> contatos = contatoRepository.findAll();
		List<ContatoDTO> contatosDTO = new ArrayList<>();
		for (Contato contato : contatos) {
			contatosDTO.add(ContatoDTO.create(contato));
		}
		return contatosDTO;
	}

	public ContatoDTO getContato(Long id) {
		Optional<Contato> contato = contatoRepository.findById(id);
		return ContatoDTO.create(contato.get());
	}
}
