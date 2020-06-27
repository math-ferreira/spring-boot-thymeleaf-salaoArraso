package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		List<Atendimento> atendimentos = atendimentosRepository.findAll();
		List<AtendimentoDTO> atendimentosDTO = new ArrayList<>();

		  Calendar cal = Calendar.getInstance();
		  cal.setTime(new Date());
		  int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
		  int semanaMes = cal.get(Calendar.WEEK_OF_MONTH);
		  int mes = cal.get(Calendar.MONTH);
		
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
				
				  if (atendimento.getDataAtendimento().after(Calendar.getInstance().getTime())
				  && atendimento.getDataAtendimento().before(cal.getTime())) {
				  atendimentosDTO.add(AtendimentoDTO.create(atendimento)); }
				 
			}
			break;
		// Atendimentos do mes vigente
		case 4:
			while(mes == Calendar.getInstance().get(Calendar.MONTH)) {
				cal.add(Calendar.DATE, 1);
				mes = cal.get(Calendar.MONTH);
			}
			for (Atendimento atendimento : atendimentos) {
				
				  if (atendimento.getDataAtendimento().after(Calendar.getInstance().getTime())
				  && atendimento.getDataAtendimento().before(cal.getTime())) {
				  atendimentosDTO.add(AtendimentoDTO.create(atendimento)); }
				 
			}
			break;
		//  Atendimentos do ano vigente
		case 5:
			break;
		// Atendimentos ja realizados
		case 6:
			for (Atendimento atendimento : atendimentos) {
				
				 if (atendimento.getDataAtendimento().before(cal.getTime())) {
				  atendimentosDTO.add(AtendimentoDTO.create(atendimento)); }
				 
			}			
			break;
		default:
			break;
		}
		return atendimentosDTO;
	}

	public AtendimentoDTO getAtendimentoById(Long id) {
		Optional<Atendimento> atendimentos = atendimentosRepository.findById(id);
		return AtendimentoDTO.create(atendimentos.get());
	}

	public AtendimentoDTO postAtendimento(Atendimento atendimentos) {
		return AtendimentoDTO.create(atendimentosRepository.save(atendimentos));
	}

	public AtendimentoDTO putAtendimento(Atendimento atendimentos, Long id) {
		Atendimento atendimentosGravado = atendimentosRepository.findById(id).get(); // .get() pois deveria retornar um
																						// Optional<>
		UpdateObjects.merge(atendimentos, atendimentosGravado);
		return AtendimentoDTO.create(atendimentosRepository.save(atendimentosGravado));
	}

	public void deleteAtendimento(Long id) {
		atendimentosRepository.deleteById(id);
	}
}
