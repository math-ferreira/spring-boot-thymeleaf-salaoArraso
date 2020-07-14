package com.salaoarrazus.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

	public List<FluxoCaixa> getReceita(Integer mes, Integer ano){
		List<FluxoCaixa> receitasFiltradas = new ArrayList<>();
		for (FluxoCaixa fluxoCaixa : receitaCaixa()) {
			if (fluxoCaixa.getData().getMonth().getValue() == mes && fluxoCaixa.getData().getYear() == ano){
				receitasFiltradas.add(fluxoCaixa);
			}
		}
		return receitasFiltradas;
	}

	public List<FluxoCaixa> getDespesa(Integer mes, Integer ano){
		List<FluxoCaixa> despesasFiltradas = new ArrayList<>();
		for (FluxoCaixa fluxoCaixa : despesaCaixa()) {
			if (fluxoCaixa.getData().getMonth().getValue() == mes && fluxoCaixa.getData().getYear() == ano){
				despesasFiltradas.add(fluxoCaixa);
			}
		}
		return despesasFiltradas;
	}

	// mes = 0 e ano = 0 -> total de receitas gravadas
	public BigDecimal getTotalReceita(Integer mes, Integer ano){
		BigDecimal receitaTotal = new BigDecimal(0);
		for (FluxoCaixa fluxoCaixa : receitaCaixa()) {
			if (mes == 0 && ano == 0){
				receitaTotal = receitaTotal.add(fluxoCaixa.getValor());
			}
			else if (fluxoCaixa.getData().getMonth().getValue() == mes && fluxoCaixa.getData().getYear() == ano){
				receitaTotal = receitaTotal.add(fluxoCaixa.getValor());
			}
		}
		return receitaTotal;
	}

	// mes = 0 e ano = 0 -> total de despesas gravadas
	public BigDecimal getTotalDespesa(Integer mes, Integer ano){
		BigDecimal despesaTotal = new BigDecimal(0);
		for (FluxoCaixa fluxoCaixa : despesaCaixa()) {
			if(mes == 0 && ano == 0){
				despesaTotal = despesaTotal.add(fluxoCaixa.getValor());
			}
			else if (fluxoCaixa.getData().getMonth().getValue() == mes && fluxoCaixa.getData().getYear() == ano){
				despesaTotal = despesaTotal.add(fluxoCaixa.getValor());
			}
		}
		return despesaTotal;
	}

	// Criar metodos:
	// dia que ganhou mais, dia que gastou mais, dia da semana que tem mais serviços, dia da semana que tem menos serviços

}
