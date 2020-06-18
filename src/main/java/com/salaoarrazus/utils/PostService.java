package com.salaoarrazus.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //Define a classe como um bean do Spring
public class PostService {
	
	//Retorna uma lista com todos posts inseridos
	public List<Post> findAll() {
		Post post = new Post();
		post.setId(1L);
		post.setAutor("autor teste");
		post.setData(new Date());
		post.setTexto("teste de exemplo é um belo texto de teste");
		post.setTitulo("Titulo teste");
		Post post2 = new Post();
		post2.setId(2L);
		post2.setAutor("autor teste 2");
		post2.setData(new Date());
		post2.setTexto("teste de exemplo é um belo texto de teste 2");
		post2.setTitulo("Titulo teste 2");
		Post post3 = new Post();
		post3.setId(3L);
		post3.setAutor("autor teste 2");
		post3.setData(new Date());
		post3.setTexto("teste de exemplo é um belo texto de teste 2");
		post3.setTitulo("Titulo teste 2");
		Post post4 = new Post();
		post4.setId(4L);
		post4.setAutor("autor teste 2");
		post4.setData(new Date());
		post4.setTexto("teste de exemplo é um belo texto de teste 2");
		post4.setTitulo("Titulo teste 2");
		return Arrays.asList(post, post2, post3, post4);
	}
	
	//Retorno um post a partir do ID
	public Post findOne(Long id) {
		Post post = new Post();
		post.setAutor("autor teste pelo id");
		post.setData(new Date());
		post.setTexto("teste de exemplo é um belo texto de teste pelo id");
		post.setTitulo("Titulo teste pelo id");
		return post;
	}
	
	//Salva ou atualiza um post
	public Post save(Post post) {
		System.out.println("Id save console: " + post.getId());
		return post;
	}
	
	//Exclui um post
	public void delete(Long id) {
		System.out.println("Id delete console: " + id);
		//repository.delete(id);
	}

}
