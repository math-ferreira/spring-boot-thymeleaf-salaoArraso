package com.salaoarrazus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoarrazus.domain.dto.ProdutoDTO;
import com.salaoarrazus.domain.model.Produto;
import com.salaoarrazus.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> getProdutos() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoDTO> produtosDTO = new ArrayList<>();
		for (Produto produto : produtos) {
			produtosDTO.add(ProdutoDTO.create(produto));
		}
		return produtosDTO;
	}

	public ProdutoDTO getProdutoById(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return ProdutoDTO.create(produto.get());
	}

	public ProdutoDTO postProduto(Produto produto) {
		return ProdutoDTO.create(produtoRepository.save(produto));
	}
	
	public ProdutoDTO putProduto(Produto produto, Long id) {
		Produto produtoUpdate = produto;
		produtoUpdate.setId(produto.getId());
		return ProdutoDTO.create(produtoRepository.save(produtoUpdate));
	}

	public void deleteProduto(Long id) {
		produtoRepository.deleteById(id);
	}
}
