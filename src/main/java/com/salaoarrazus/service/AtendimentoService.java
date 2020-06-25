package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.AtendimentoDTO;
import com.salaoarrazus.domain.model.Atendimento;
import com.salaoarrazus.repository.AtendimentoRepository;
import com.salaoarrazus.service.config.UpdateObjects;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	public List<AtendimentoDTO> getAtendimentos() {
		List<Atendimento> atendimentos = atendimentoRepository.findAll();
		List<AtendimentoDTO> atendimentosDTO = new ArrayList<>();
		for (Atendimento atendimento : atendimentos) {
			atendimentosDTO.add(AtendimentoDTO.create(atendimento));
		}
		return atendimentosDTO;
	}

	public AtendimentoDTO getAtendimentoById(Long id) {
		Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
		return AtendimentoDTO.create(atendimento.get());
	}

	public AtendimentoDTO postAtendimento(Atendimento atendimento) {
		return AtendimentoDTO.create(atendimentoRepository.save(atendimento));
	}

	public AtendimentoDTO putAtendimento(Atendimento atendimento, Long id) {
		Atendimento atendimentoGravado = atendimentoRepository.findById(id).get(); // .get() pois deveria retornar um Optional<>
		UpdateObjects.merge(atendimento, atendimentoGravado);
		return AtendimentoDTO.create(atendimentoRepository.save(atendimentoGravado));
	}

	public void deleteAtendimento(Long id) {
		atendimentoRepository.deleteById(id);
	}
}
