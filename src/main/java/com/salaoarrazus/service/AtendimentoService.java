package com.salaoarrazus.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.AtendimentoDTO;
import com.salaoarrazus.domain.model.Atendimento;
import com.salaoarrazus.repository.AtendimentoRepository;
import com.salaoarrazus.service.config.PeriodicidadeAtendimentos;
import com.salaoarrazus.service.config.UpdateObjects;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentosRepository;

	public List<AtendimentoDTO> getAtendimentos(PeriodicidadeAtendimentos periodicidadeAtendimentos) {
		List<Atendimento> atendimentos = atendimentosRepository.findAll(Sort.by(Sort.Direction.ASC, "dataAtendimento"));
		converteDataGTMLocal(atendimentos);
		List<AtendimentoDTO> atendimentosDTO = new ArrayList<>();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
		int mes = cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);

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
			for (int i = diaSemana; i < 7; i++) {
				cal.add(Calendar.DATE, 1);
			}
			for (Atendimento atendimento : atendimentos) {

				if (atendimento.getDataAtendimento().isAfter(LocalDateTime.now()) && atendimento.getDataAtendimento()
						.isBefore(LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
								cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE)))) {
					atendimentosDTO.add(AtendimentoDTO.create(atendimento));
				}

			}
			break;
		// Atendimentos do mes vigente
		case 4:
			while (mes == Calendar.getInstance().get(Calendar.MONTH)) {
				cal.add(Calendar.DATE, 1);
				mes = cal.get(Calendar.MONTH);
			}
			cal.add(Calendar.MONTH, 1);
			for (Atendimento atendimento : atendimentos) {

				if (atendimento.getDataAtendimento().isAfter(LocalDateTime.now()) && atendimento.getDataAtendimento()
						.isBefore(LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
								cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE)))) {
					atendimentosDTO.add(AtendimentoDTO.create(atendimento));
				}

			}
			break;
		// Atendimentos do ano vigente
		case 5:
			while (ano == Calendar.getInstance().get(Calendar.YEAR)) {
				cal.add(Calendar.DATE, 1);
				ano = cal.get(Calendar.YEAR);
			}
			cal.add(Calendar.YEAR, 1);
			for (Atendimento atendimento : atendimentos) {

				if (atendimento.getDataAtendimento().isAfter(LocalDateTime.now()) && atendimento.getDataAtendimento()
						.isBefore(LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
								cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE)))) {
					atendimentosDTO.add(AtendimentoDTO.create(atendimento));
				}

			}
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

	public List<Atendimento> converteDataGTMLocal(List<Atendimento> atendimentos) {
		for (Atendimento atendimento : atendimentos) {
			atendimento.setDataAtendimento(atendimento.getDataAtendimento().plusHours(3));
		}
		return atendimentos;
	}

	public AtendimentoDTO getAtendimentoById(Long id) {
		Optional<Atendimento> atendimentos = atendimentosRepository.findById(id);
		return AtendimentoDTO.create(atendimentos.get());
	}

	public AtendimentoDTO postAtendimento(Atendimento atendimento) {
		return AtendimentoDTO.create(atendimentosRepository.save(atendimento));
	}

	public AtendimentoDTO putAtendimento(Atendimento atendimento, Long id) {
		Atendimento atendimentosGravado = atendimentosRepository.findById(id).get(); // .get() pois deveria retornar um
																						// Optional<>
		UpdateObjects.merge(atendimento, atendimentosGravado);
		return AtendimentoDTO.create(atendimentosRepository.save(atendimentosGravado));
	}

	public void deleteAtendimento(Long id) {
		atendimentosRepository.deleteById(id);
	}
}
