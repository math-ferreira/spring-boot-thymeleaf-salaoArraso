package com.salaoarrazus.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.salaoarrazus.domain.dto.AtendimentoDTO;
import com.salaoarrazus.domain.dto.PessoaDTO;
import com.salaoarrazus.domain.model.Atendimento;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.repository.AtendimentoRepository;
import com.salaoarrazus.service.config.PeriodicidadeAtendimentosEnum;
import com.salaoarrazus.service.config.UpdateObjectsService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentosRepository;

	@Autowired
	private PessoaService pessoaService;


	public List<AtendimentoDTO> getAtendimentos(PeriodicidadeAtendimentosEnum periodicidadeAtendimentos) {
		List<Atendimento> atendimentos = atendimentosRepository.findAll(Sort.by(Sort.Direction.ASC, "dataAtendimento"));
		List<AtendimentoDTO> atendimentosDTO = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		switch (periodicidadeAtendimentos.getCode()) {
			// Todos os Atendimentos
			case 1:
				for (Atendimento atendimento : atendimentos) {
					atendimentosDTO.add(AtendimentoDTO.create(atendimento));
				}
				break;
			// Atendimentos do dia
			case 2:
				break;
			// Atendimentos da semana vigente
			case 3:
				break;
			// Atendimentos do mes vigente
			case 4:
				break;
			// Atendimentos do ano vigente
			case 5:
				break;
			// Atendimentos ja realizados
			case 6:
				for (Atendimento atendimento : atendimentos) {

					if (atendimento.getDataAtendimento().isAfter(LocalDateTime.now())) {
						atendimentosDTO.add(AtendimentoDTO.create(atendimento));
					}
				}
				break;
			default:
				break;
		}
		return atendimentosDTO;
	}

	public List<AtendimentoDTO> converteDataGTMLocal(List<AtendimentoDTO> atendimentos) {
		for (AtendimentoDTO atendimento : atendimentos) {
			atendimento.setDataAtendimento(atendimento.getDataAtendimento().plusHours(3));
		}
		return atendimentos;
	}

	public AtendimentoDTO getAtendimentoById(Long id) {
		Atendimento atendimentos = atendimentosRepository.findById(id).get();
		atendimentos.setDataAtendimento(atendimentos.getDataAtendimento().plusHours(3));
		return AtendimentoDTO.create(atendimentos);
	}

	public AtendimentoDTO postAtendimento(Atendimento atendimento) {
		return AtendimentoDTO.create(atendimentosRepository.save(atendimento));
	}

	public AtendimentoDTO putAtendimento(Atendimento atendimento, Long id) {
		Atendimento atendimentoGravado = atendimentosRepository.findById(id).get();
		Long idPessoaGravada = atendimentoGravado.getPessoa().getId();
		Long idPessoaUpdate = atendimento.getPessoa().getId();
		UpdateObjectsService.merge(atendimento, atendimentoGravado);
		if (!idPessoaGravada.equals(idPessoaUpdate)){
			PessoaDTO pessoaDTO = pessoaService.getPessoaById(idPessoaUpdate);
			List<Atendimento> atendimentos = pessoaDTO.getAtendimentos();
			atendimentos.add(atendimento);
			pessoaDTO.setAtendimentos(atendimentos);
			
			ModelMapper modelMapper = new ModelMapper();
			Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
			atendimentoGravado.setPessoa(pessoa);
		}

		return AtendimentoDTO.create(atendimentosRepository.save(atendimentoGravado));
	}

	public void deleteAtendimento(Long id) {
		atendimentosRepository.deleteById(id);
	}
}
