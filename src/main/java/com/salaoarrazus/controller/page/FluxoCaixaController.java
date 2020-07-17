package com.salaoarrazus.controller.page;

import java.math.BigDecimal;
import java.util.List;

import com.salaoarrazus.domain.model.FluxoCaixa;
import com.salaoarrazus.service.FluxoCaixaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/organizacao/fluxo-caixa")
public class FluxoCaixaController {

	@Autowired
	private FluxoCaixaService fluxoCaixaService;

	@GetMapping()
	public String fluxo(ModelMap model) throws Exception {
		return "organizacao/index-fluxo-de-caixa";
	}

	@GetMapping("/saldo-receitas")
	public ResponseEntity<BigDecimal> getSaldoTotalReceita(@RequestParam("mes") Integer mes, @RequestParam("ano") Integer ano ){
		return ResponseEntity.ok(fluxoCaixaService.getSaldoTotalReceita(mes, ano));
	}

	@GetMapping("/saldo-despesas")
	public ResponseEntity<BigDecimal> getSaldoTotalDespesa(@RequestParam("mes") Integer mes, @RequestParam("ano") Integer ano ){
		return ResponseEntity.ok(fluxoCaixaService.getSaldoTotalDespesa(mes, ano));
	}

	@GetMapping("/lista-despesas")
	public ResponseEntity<List<FluxoCaixa>> getListaDespesa(@RequestParam("mes") Integer mes, @RequestParam("ano") Integer ano ){
		return ResponseEntity.ok(fluxoCaixaService.getListaDespesas(mes, ano));
	}

	@GetMapping("/lista-receitas")
	public ResponseEntity<List<FluxoCaixa>> getListaReceita(@RequestParam("mes") Integer mes, @RequestParam("ano") Integer ano ){
		return ResponseEntity.ok(fluxoCaixaService.getListaReceitas(mes, ano));
	}
}
