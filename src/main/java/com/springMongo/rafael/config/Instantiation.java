package com.springMongo.rafael.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springMongo.rafael.domain.Post;
import com.springMongo.rafael.domain.User;
import com.springMongo.rafael.dto.AuthorDTO;
import com.springMongo.rafael.repositories.PostRepositories;
import com.springMongo.rafael.repositories.UserRepositories;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepositories userRepo;
	
	@Autowired
	private PostRepositories postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepo.deleteAll();
		postRepo.deleteAll();

		
		User us1 = new User(null, "polo", "polo@gmaill");
		User us2 = new User(null, "polo", "polo@gmaill");		
		User us3 = new User(null, "polo", "polo@gmaill");
		
		
		Post pos1 = new Post(null, sdf.parse("25/05/2000"), "Partiu viagem", "Vou viajar", new AuthorDTO(us1));
		Post pos2 = new Post(null, sdf.parse("25/05/2000"), "Partiu minas", "aeeee", new AuthorDTO(us1));
		Post pos3 = new Post(null, sdf.parse("25/05/2000"), "Partiu japao", "bora andar de barco", new AuthorDTO(us1));
		
		
		postRepo.saveAll(Arrays.asList(pos1, pos2, pos3));
		
		us1.getPosts().addAll(Arrays.asList(pos1, pos2, pos3));
		

		userRepo.saveAll(Arrays.asList(us1, us2, us3));

		
	}

}
