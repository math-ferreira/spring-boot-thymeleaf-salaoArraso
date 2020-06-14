package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.FornecedorDTO;
import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public List<FornecedorDTO> getFornecedores() {
		List<Fornecedor> fornecedores = fornecedorRepository.findAll();
		List<FornecedorDTO> fornecedoresDTO = new ArrayList<>();
		for (Fornecedor fornecedor : fornecedores) {
			fornecedoresDTO.add(FornecedorDTO.create(fornecedor));
		}
		return fornecedoresDTO;
	}

	public FornecedorDTO getFornecedorById(Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return FornecedorDTO.create(fornecedor.get());
	}
	
	public FornecedorDTO postFornecedor(Fornecedor fornecedor) {
		return FornecedorDTO.create(fornecedorRepository.save(fornecedor));
	}

	public FornecedorDTO putFornecedor(Fornecedor fornecedor, Long id) {
		Fornecedor fornecedorUpdate = fornecedor;
		fornecedorUpdate.setId(fornecedor.getId());
		return FornecedorDTO.create(fornecedorRepository.save(fornecedorUpdate));
	}

	public void deleteFornecedor(Long id) {
		fornecedorRepository.deleteById(id);
	}
}
