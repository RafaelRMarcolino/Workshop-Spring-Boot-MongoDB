package com.springMongo.rafael.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMongo.rafael.domain.User;
import com.springMongo.rafael.dto.UserDTO;
import com.springMongo.rafael.repositories.UserRepositories;
import com.springMongo.rafael.service.excepion.ObjectNotFoundException;

@Service
public class UserServices {
	
	@Autowired
	private UserRepositories repo;
	
	public List<User>  findAll(){
		return repo.findAll();
	}
	
	public User findId(String id) {
		
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}

	public User send(User user) {
		
		return user = repo.save(user);
	}
	
	public User fromDTO(UserDTO objDTO) {
		
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}
