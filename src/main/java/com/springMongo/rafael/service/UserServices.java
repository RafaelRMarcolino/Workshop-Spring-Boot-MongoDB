package com.springMongo.rafael.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMongo.rafael.domain.User;
import com.springMongo.rafael.repositories.UserRepositories;

@Service
public class UserServices {
	
	@Autowired
	private UserRepositories repo;
	
	public List<User>  findAll(){
		return repo.findAll();
		
	}

}
