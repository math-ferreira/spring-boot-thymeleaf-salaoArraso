package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.EnderecoDTO;
import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<EnderecoDTO> getEnderecos() {
		List<Endereco> enderecos = enderecoRepository.findAll();
		List<EnderecoDTO> enderecosDTO = new ArrayList<>();
		for (Endereco endereco : enderecos) {
			enderecosDTO.add(EnderecoDTO.create(endereco));
		}
		return enderecosDTO;
	}

	public EnderecoDTO getEnderecoById(Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return EnderecoDTO.create(endereco.get());
	}

	public EnderecoDTO putEndereco(Endereco endereco, Long id) {
		Endereco enderecoUpdate = endereco;
		enderecoUpdate.setId(endereco.getId());
		return EnderecoDTO.create(enderecoRepository.save(enderecoUpdate));
	}

	public void deleteEndereco(Long id) {
		enderecoRepository.deleteById(id);
	}
}
