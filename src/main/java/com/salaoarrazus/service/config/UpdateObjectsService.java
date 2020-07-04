package com.salaoarrazus.service.config;

import com.salaoarrazus.domain.model.Atendimento;
import com.salaoarrazus.domain.model.Fornecedor;
import com.salaoarrazus.domain.model.Pessoa;
import com.salaoarrazus.domain.model.Telefone;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

/**
 * Classe para tratar os objetos antes do update no Banco de Dados
 * @author matsf
 *	
 */
public class UpdateObjectsService {

	/**
	 * merge entre dois objectos, descartando valores nulos
	 * @param input
	 * @param output
	 * @return output
	 */
	
	public static Object merge(Object input, Object output) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.getConfiguration().setDeepCopyEnabled(true);
		modelMapper.map(input, output);
		return output;
	}

	public static Atendimento associaPessoaAtendimento(Atendimento atendimentoGravado, Atendimento atendimentoUpdate){
		Long idPessoaGravada = atendimentoGravado.getPessoa().getId();
		Long idPessoaUpdate = atendimentoUpdate.getPessoa().getId();
		if (!idPessoaGravada.equals(idPessoaUpdate)){
			
		}
		return null;
	}
	
	/**
	 * Associa a coleção de telefones ao objeto pessoa
	 * @param pessoa
	 * @return pessoa
	 */
	
	public static Pessoa associaPessoaTelefone(Pessoa pessoa) {
		for (Telefone telefone : pessoa.getContato().getTelefones()) {
			telefone.setContato(pessoa.getContato());
		}
		return pessoa;
	}
	
	/**
	 * Associa a coleção de telefones ao objeto fornecedor
	 * @param fornecedor
	 * @return fornecedor
	 */
	
	public static Fornecedor associaFornecedorTelefone(Fornecedor fornecedor) {
		for (Telefone telefone : fornecedor.getContato().getTelefones()) {
			telefone.setContato(fornecedor.getContato());
		}
		return fornecedor;
	}
	//public static double 

}
