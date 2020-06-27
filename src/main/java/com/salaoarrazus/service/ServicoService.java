package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.ServicoDTO;
import com.salaoarrazus.domain.model.Servico;
import com.salaoarrazus.repository.ServicoRepository;
import com.salaoarrazus.service.config.UpdateObjects;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public List<ServicoDTO> getServicos() {
		List<Servico> servicos = servicoRepository.findAll();
		List<ServicoDTO> servicosDTO = new ArrayList<>();
		for (Servico servico : servicos) {
			servicosDTO.add(ServicoDTO.create(servico));
		}
		return servicosDTO;
	}

	public ServicoDTO getServicoById(Long id) {
		Optional<Servico> servico = servicoRepository.findById(id);
		return ServicoDTO.create(servico.get());
	}

	public ServicoDTO postServico(Servico servico) {
		return ServicoDTO.create(servicoRepository.save(servico));
	}

	public ServicoDTO putServico(Servico servico, Long id) {
		Servico servicoGravado = servicoRepository.findById(id).get(); // .get() pois deveria retornar um Optional<>
		UpdateObjects.merge(servico, servicoGravado);
		return ServicoDTO.create(servicoRepository.save(servicoGravado));
	}

	public void deleteServico(Long id) {
		servicoRepository.deleteById(id);
	}
}
