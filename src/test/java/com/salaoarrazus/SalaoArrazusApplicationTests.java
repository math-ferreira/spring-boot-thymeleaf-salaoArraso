package com.salaoarrazus;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salaoarrazus.domain.dto.PessoaDTO;
import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.domain.model.enums.StatusPessoa;
import com.salaoarrazus.service.ContatoService;
import com.salaoarrazus.service.EnderecoService;
import com.salaoarrazus.service.PessoaService;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SalaoArrazusApplicationTests {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private EnderecoService enderecoService;

	@Test
	void testAEnderecoPOST() {
		
	}
	
	@Test
	void testAPOST() {
		Endereco endereco = new Endereco(null, "Rau Speers", "Jabarema", "113", "0829873", "São Caetano do Sul", "SP");
		enderecoService.postEndereco(endereco);
		
		Contato contato = new Contato(null, "mat.s.ferreira@gmail.com");
		contatoService.postContato(contato);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Matheus");
		pessoa.setStatusPessoa(StatusPessoa.FUNCIONARIO);
		pessoa.setContato(contato);
		pessoa.setEndereco(endereco);
		pessoaService.postPessoa(pessoa);
	}
	
	@Test
	void testBGET() {
		List<PessoaDTO> pessoasDTO = pessoaService.getPessoas();
		assertNotNull(pessoasDTO);
	}

}
