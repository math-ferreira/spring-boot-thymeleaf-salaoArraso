package com.salaoarrazus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import com.salaoarrazus.domain.model.Contato;
import com.salaoarrazus.domain.model.Endereco;
import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.domain.model.Produto;
import com.salaoarrazus.domain.model.Telefone;
import com.salaoarrazus.domain.model.enums.StatusCaixa;
import com.salaoarrazus.domain.model.enums.StatusPagamento;
import com.salaoarrazus.domain.model.enums.TipoTelefone;
import com.salaoarrazus.service.ContatoService;
import com.salaoarrazus.service.EnderecoService;
import com.salaoarrazus.service.FornecedorService;
import com.salaoarrazus.service.PessoaService;
import com.salaoarrazus.service.ProdutoService;
import com.salaoarrazus.service.TelefoneService;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SalaoArrazusApplicationTests {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private ContatoService contatoService;

	@Autowired
	private TelefoneService telefoneService;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private ProdutoService produtoService;

	// ## (PESSOA) - GET - POST - PUT - DELETE

	@Test
	void testAPOST() {
		Endereco endereco = new Endereco(null, "Rua Speers", "Jabarema", "113", "0829873", "São Caetano do Sul", "SP");
		enderecoService.postEndereco(endereco);
		System.out.println(enderecoService.getEnderecos());

		Contato contato = new Contato(null, "mat.s.ferreira@gmail.com");
		contatoService.postContato(contato);

		Telefone telefone = new Telefone(null, TipoTelefone.CELULAR, "110293892322", contato);
		telefoneService.postTelefone(telefone);

		System.out.println(contatoService.getContatos());

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Matheus");
		//pessoa.setStatusPessoa(TipoAtendimento.FUNCIONARIO);
		pessoa.setContato(contato);
		pessoa.setEndereco(endereco);
		pessoaService.postPessoa(pessoa);
	}

	@Test
	void testBGET() {
		assertNotNull(pessoaService.getPessoas());
		assertNotNull(enderecoService.getEnderecos());
		assertNotNull(contatoService.getContatos());
	}

	@Test
	void testCPUT() {
		Pessoa pessoa = new Pessoa();
		//pessoa.setStatusPessoa(TipoAtendimento.PEDICURE);
		pessoaService.putPessoa(pessoa, 1L);
		assertEquals(pessoaService.getPessoas().get(0).getNome(), "Matheus");
		//assertEquals(pessoaService.getPessoas().get(0).getStatusPessoa(), TipoAtendimento.PEDICURE);
	}

	@Test
	void testDDELETE() {
		assertEquals(pessoaService.getPessoas().size(), 1);
		pessoaService.deletePessoa(1l);
		assertEquals(pessoaService.getPessoas().size(), 0);
	}

	// ## (ENDERECO) - GET - POST - PUT - DELETE
	
	@Test
	void testEPUT() {
		Endereco end = new Endereco(null, "Rua Rio Souza", "Palmes", "44", "129933", "Lins de Vasconcelos", "MG");
		enderecoService.postEndereco(end);
		assertEquals(enderecoService.getEnderecos().size(), 2);
		Endereco endUpdate = new Endereco();
		endUpdate.setCidade("Vinhedo");
		endUpdate.setNumero("666");
		enderecoService.putEndereco(endUpdate, 2L);
		
		assertEquals(enderecoService.getEnderecos().size(), 2);
		assertEquals(enderecoService.getEnderecos().get(1).getEstado(), "MG");
		assertEquals(enderecoService.getEnderecos().get(1).getCidade(), "Vinhedo");
	}
	
	@Test
	void testFDELETE() {
		assertEquals(enderecoService.getEnderecos().size(), 2);
		enderecoService.deleteEndereco(2l);
		assertEquals(enderecoService.getEnderecos().size(), 1);
	}
	
	// ## (CONTATO E TELEFONE) - GET - POST - PUT - DELETE
	
	@Test
	void testeFTelefoneContato() {
		Contato c = new Contato(null, "maysaprado@gmail.com");
		Telefone tel = new Telefone(null, TipoTelefone.RESIDENCIAL, "1498320983", c);
		
		contatoService.postContato(c);
		telefoneService.postTelefone(tel);
		
		assertEquals(contatoService.getContatos().size(), 2);
		assertEquals(telefoneService.getTelefones().size(), 2);
		
		Telefone tel2 = new Telefone();
		tel2.setNumeroTelefone("667872938922");
		tel2.setTipoTelefone(TipoTelefone.RESIDENCIAL);
		telefoneService.putTelefone(tel2, 2L);
		assertEquals(telefoneService.getTelefones().get(1).getNumeroTelefone(), "667872938922");
		assertEquals(telefoneService.getTelefones().get(1).getTipoTelefone(), TipoTelefone.RESIDENCIAL);
		assertEquals(telefoneService.getTelefones().size(), 2);
		
		Contato c2 = new Contato();
		c2.setEmail("maysa.do.prado@outlook.com");
		contatoService.putContato(c2, 2L);
		assertEquals(contatoService.getContatos().get(1).getEmail(), "maysa.do.prado@outlook.com");
		assertEquals(contatoService.getContatos().size(), 2);
		
		telefoneService.deleteTelefone(2L);
		assertEquals(telefoneService.getTelefones().size(), 1);
		
		contatoService.deleteContato(2L);
		assertEquals(contatoService.getContatos().size(), 1);
	}
	
	// ## (PRODUTO E FORNECEDORES) - GET - POST - PUT - DELETE
	
	@Test
	void testeGFornecedorProduto() {
		Contato c = new Contato(null, "math_tomates@gmail.com");
		Telefone tel = new Telefone(null, TipoTelefone.COMERCIAL, "9834934344", c);
		
		contatoService.postContato(c);
		telefoneService.postTelefone(tel);
		
		Endereco endereco = new Endereco(null, "Rua Jacuiba", "Salete", "554", "0324929", "Taubaté", "SP");
		enderecoService.postEndereco(endereco);
		
		Fornecedor fornecedor = new Fornecedor(null, "Math tomates", "90234894323", "Alimentos", c, endereco);
		fornecedorService.postFornecedor(fornecedor);
		
		Produto produto = new Produto(null, "Café Extra-forte", 5, 16.33, new Date(), StatusPagamento.PAGO, StatusCaixa.SAIDA, fornecedor);
		produtoService.postProduto(produto);
		
		assertEquals(fornecedorService.getFornecedores().size(), 1);
		assertEquals(produtoService.getProdutos().size(), 1);
		
		Fornecedor fornecedor2 = new Fornecedor();
		fornecedor2.setRamo("Alimentos e também Higiene");
		fornecedorService.putFornecedor(fornecedor2, 1L);
		assertEquals(fornecedorService.getFornecedores().get(0).getNome(), "Math tomates");
		assertEquals(fornecedorService.getFornecedores().get(0).getRamo(), "Alimentos e também Higiene");
		assertEquals(fornecedorService.getFornecedores().size(), 1);
		
		Produto produto2 = new Produto();
		produto2.setDescricaoProduto("Na verdade Café padrão");
		produto2.setStatusCaixa(StatusCaixa.SAIDA);
		produto2.setStatusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO);
		produtoService.putProduto(produto2, 1L);
		assertEquals(produtoService.getProdutos().get(0).getDescricaoProduto(), "Na verdade Café padrão");
		assertThat(produtoService.getProdutos().get(0).getValor() == 16.33);
		assertEquals(produtoService.getProdutos().size(), 1);
		
		produtoService.deleteProduto(1L);;
		assertEquals(produtoService.getProdutos().size(), 0);
		fornecedorService.deleteFornecedor(1L);
		assertEquals(fornecedorService.getFornecedores().size(), 0);
	}
	
}
