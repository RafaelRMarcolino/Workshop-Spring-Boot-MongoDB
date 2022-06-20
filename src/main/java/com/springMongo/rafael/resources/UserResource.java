package com.springMongo.rafael.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springMongo.rafael.domain.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> send() {
		
		List<User> obj = new ArrayList<>();
		
		User us1 = new User(null, "maria", "maria@");
		User us2 = new User(null, "fernando", "fernandoa@");
		User us3 = new User(null, "fernando", "fernandoa@");

		
		obj.addAll(Arrays.asList(us1, us2, us3));
		return ResponseEntity.ok().body(obj);
	}

}
