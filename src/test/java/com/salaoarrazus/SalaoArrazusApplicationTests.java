package com.salaoarrazus;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salaoarrazus.domain.dto.PessoaDTO;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.domain.model.enums.StatusPessoa;
import com.salaoarrazus.service.PessoaService;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SalaoArrazusApplicationTests {

	@Autowired
	private PessoaService pessoaService;
	@Autowired
	// FALTA OS SERVICES AQUI

	@Test
	void testAEnderecoPOST() {
		
	}
	
	@Test
	void testAPOST() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Matheus");
		pessoa.setStatusPessoa(StatusPessoa.FUNCIONARIO);
		pessoaService.postPessoa(pessoa);
	}
	
	@Test
	void testBGET() {
		List<PessoaDTO> pessoasDTO = pessoaService.getPessoas();
		assertNotNull(pessoasDTO);
	}

}
