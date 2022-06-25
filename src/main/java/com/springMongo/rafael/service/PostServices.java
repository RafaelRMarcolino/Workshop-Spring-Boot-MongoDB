package com.springMongo.rafael.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMongo.rafael.domain.Post;
import com.springMongo.rafael.repositories.PostRepositories;
import com.springMongo.rafael.service.excepion.ObjectNotFoundException;

@Service
public class PostServices {

	@Autowired
	private PostRepositories repo;

	

	public Post findId(String id) {

		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}
	
	public List<Post> findByIdTitle(String text){
		
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
