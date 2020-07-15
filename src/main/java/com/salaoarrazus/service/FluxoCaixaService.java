package com.salaoarrazus.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.salaoarrazus.domain.dto.AtendimentoDTO;
import com.salaoarrazus.domain.dto.ProdutoDTO;
import com.salaoarrazus.domain.model.FluxoCaixa;
import com.salaoarrazus.service.config.PeriodicidadeAtendimentosEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FluxoCaixaService {

	@Autowired
	private AtendimentoService atendimentoService;

	@Autowired
	private ProdutoService produtoService;

	// Retorna a lista de todas as Receitas para o mes e ano de referencia
	public List<FluxoCaixa> getListaReceitas(Integer mes, Integer ano) {
		return getCaixa(mes, ano, receitaCaixa());
	}

	// Retorna a lista de todas as Despesas para o mes e ano de referencia
	public List<FluxoCaixa> getListaDespesas(Integer mes, Integer ano) {
		return getCaixa(mes, ano, despesaCaixa());
	}

	// Valor total para receitas no mes e ano
	// mes = 0 e ano = 0 -> total de receitas gravadas
	public BigDecimal getTotalReceita(Integer mes, Integer ano) {
		return getTotalCaixa(mes, ano, receitaCaixa());
	}

	// Valor total para despesas no mes e ano
	// mes = 0 e ano = 0 -> total de despesas gravadas
	public BigDecimal getTotalDespesa(Integer mes, Integer ano) {
		return getTotalCaixa(mes, ano, despesaCaixa());
	}

	// Dia total com maior receita
	public LocalDateTime getDiaMaiorReceita() {
		return getDiaMaiorCaixa(receitaCaixa());
	}

	// Dia total com maior despesa
	public LocalDateTime getDiaMaiorDespesa() {
		return getDiaMaiorCaixa(despesaCaixa());
	}

	// Dia da semana com maior servicos
	public String getDiaSemanaMaiorReceita() {
		return getDiaSemanaCaixa(true, receitaCaixa());
	}

	// Dia da semana com menos servicos
	public String getDiaSemanaMenorReceita() {
		return getDiaSemanaCaixa(false, receitaCaixa());
	}

	// Dia da semana com maior despesa
	public String getDiaSemanaMaiorDespesa() {
		return getDiaSemanaCaixa(true, despesaCaixa());
	}

	// Dia da semana com menor despesa
	public String getDiaSemanaMenorDespesa() {
		return getDiaSemanaCaixa(false, despesaCaixa());
	}

	// -- métodos privados --//

	private String getDiaSemanaCaixa(boolean opcaoMaior, List<FluxoCaixa> fluxoCaixaDesejado) {
		HashMap<String, Integer> diaSemana = new HashMap<>();
		diaSemana.put("Segunda-feira", 0);
		diaSemana.put("Terça-feira", 0);
		diaSemana.put("Quarta-feira", 0);
		diaSemana.put("Quinta-feira", 0);
		diaSemana.put("Sexta-feira", 0);
		diaSemana.put("Sabado", 0);
		diaSemana.put("Domingo", 0);

		for (FluxoCaixa fluxoCaixa : fluxoCaixaDesejado) {
			switch (fluxoCaixa.getData().getDayOfWeek().getValue()) {
				case 1:
					diaSemana.put("Segunda-feira", diaSemana.get("Segunda-feira") + 1);
					break;
				case 2:
					diaSemana.put("Terça-feira", diaSemana.get("Terça-feira") + 1);
					break;
				case 3:
					diaSemana.put("Quarta-feira", diaSemana.get("Quarta-feira") + 1);
					break;
				case 4:
					diaSemana.put("Quinta-feira", diaSemana.get("Quinta-feira") + 1);
					break;
				case 5:
					diaSemana.put("Sexta-feira", diaSemana.get("Sexta-feira") + 1);
					break;
				case 6:
					diaSemana.put("Sabado", diaSemana.get("Sabado") + 1);
					break;
				default:
					diaSemana.put("Domingo", diaSemana.get("Domingo") + 1);
					break;
			}
		}

		int valor;

		if (opcaoMaior) {
			valor = Collections.max(diaSemana.values());
		} else {
			valor = Collections.min(diaSemana.values());
		}
		for (Entry<String, Integer> entry : diaSemana.entrySet()) {
			if (entry.getValue() == valor) {
				return entry.getKey();
			}
		}
		return null;
	}

	private List<FluxoCaixa> receitaCaixa() {
		List<FluxoCaixa> totalFluxoCaixa = new ArrayList<>();
		List<AtendimentoDTO> atendimentos = atendimentoService.getAtendimentos(PeriodicidadeAtendimentosEnum.TODOS);
		if (atendimentos.size() != 0) {
			for (AtendimentoDTO atendimento : atendimentos) {
				FluxoCaixa fluxoCaixa = new FluxoCaixa();
				fluxoCaixa.setDescricao(atendimento.getTipoAtendimento().toString());
				fluxoCaixa.setData(atendimento.getDataAtendimento());
				fluxoCaixa.setValor(atendimento.getValorAtendimento());
				totalFluxoCaixa.add(fluxoCaixa);
			}
		}
		return totalFluxoCaixa;
	}

	private List<FluxoCaixa> despesaCaixa() {
		List<FluxoCaixa> totalFluxoCaixa = new ArrayList<>();
		List<ProdutoDTO> produtos = produtoService.getProdutos();
		if (produtos.size() != 0) {
			for (ProdutoDTO produto : produtos) {
				FluxoCaixa fluxoCaixa = new FluxoCaixa();
				fluxoCaixa.setDescricao(produto.getDescricaoProduto());
				fluxoCaixa.setData(produto.getData());
				fluxoCaixa.setValor(produto.getValor());
				totalFluxoCaixa.add(fluxoCaixa);
			}
		}
		return totalFluxoCaixa;
	}

	private List<FluxoCaixa> getCaixa(Integer mes, Integer ano, List<FluxoCaixa> fluxoCaixaDesejado) {
		List<FluxoCaixa> caixaFiltrado = new ArrayList<>();
		for (FluxoCaixa fluxoCaixa : fluxoCaixaDesejado) {
			if (fluxoCaixa.getData().getMonth().getValue() == mes && fluxoCaixa.getData().getYear() == ano) {
				caixaFiltrado.add(fluxoCaixa);
			}
		}
		return caixaFiltrado;
	}

	private BigDecimal getTotalCaixa(Integer mes, Integer ano, List<FluxoCaixa> fluxoCaixaDesejado) {
		BigDecimal caixaTotal = new BigDecimal(0);
		for (FluxoCaixa fluxoCaixa : fluxoCaixaDesejado) {
			if (mes == 0 && ano == 0) {
				caixaTotal = caixaTotal.add(fluxoCaixa.getValor());
			} else if (fluxoCaixa.getData().getMonth().getValue() == mes && fluxoCaixa.getData().getYear() == ano) {
				caixaTotal = caixaTotal.add(fluxoCaixa.getValor());
			}
		}
		return caixaTotal;
	}

	private LocalDateTime getDiaMaiorCaixa(List<FluxoCaixa> fluxoCaixaDesejado) {
		BigDecimal caixaNoDia = new BigDecimal(0);
		LocalDateTime diaMaiorReceita = LocalDateTime.now();
		for (FluxoCaixa fluxoCaixa : fluxoCaixaDesejado) {
			if (fluxoCaixa.getValor().compareTo(caixaNoDia) == 1) {
				caixaNoDia = fluxoCaixa.getValor();
				diaMaiorReceita = fluxoCaixa.getData();
			}
		}
		return diaMaiorReceita;
	}
}
