package com.springMongo.rafael.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springMongo.rafael.domain.User;
import com.springMongo.rafael.service.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	public UserServices services;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

		List<User> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}

}
