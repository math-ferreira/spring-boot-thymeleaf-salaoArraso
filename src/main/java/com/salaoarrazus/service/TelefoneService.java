package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.TelefoneDTO;
import com.salaoarrazus.domain.model.Telefone;
import com.salaoarrazus.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;

	public List<TelefoneDTO> getTelefones() {
		List<Telefone> telefones = telefoneRepository.findAll();
		List<TelefoneDTO> telefonesDTO = new ArrayList<>();
		for (Telefone telefone : telefones) {
			telefonesDTO.add(TelefoneDTO.create(telefone));
		}
		return telefonesDTO;
	}

	public TelefoneDTO getTelefoneById(Long id) {
		Optional<Telefone> telefone = telefoneRepository.findById(id);
		return TelefoneDTO.create(telefone.get());
	}

	public TelefoneDTO putTelefone(Telefone telefone, Long id) {
		Telefone telefoneUpdate = telefone;
		telefoneUpdate.setId(telefone.getId());
		return TelefoneDTO.create(telefoneRepository.save(telefoneUpdate));
	}

	public void deleteTelefone(Long id) {
		telefoneRepository.deleteById(id);
	}
}