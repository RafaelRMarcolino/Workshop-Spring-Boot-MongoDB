package com.springMongo.rafael.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springMongo.rafael.domain.User;
import com.springMongo.rafael.repositories.UserRepositories;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepositories userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User us1 = new User(null, "polo", "polo@gmaill");
		User us2 = new User(null, "polo", "polo@gmaill");		
		User us3 = new User(null, "polo", "polo@gmaill");
		
		userRepo.saveAll(Arrays.asList(us1, us2, us3));
		
	}

}
