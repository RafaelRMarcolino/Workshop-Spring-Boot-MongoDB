package com.springMongo.rafael.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springMongo.rafael.domain.User;
import com.springMongo.rafael.dto.UserDTO;
import com.springMongo.rafael.service.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	public UserServices services;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = services.findAll();
		List<UserDTO> listDTO = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> finById(@PathVariable String id) {

		User obj = services.findId(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> send(@RequestBody UserDTO objDTO) {

		User obj = services.fromDTO(objDTO);
		obj = services.send(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {

		services.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> delete(@PathVariable String id, @RequestBody UserDTO newObj) {

		User obj = services.fromDTO(newObj);
		obj.setId(id);
		obj = services.update(obj);
		return ResponseEntity.noContent().build();
		
	}

}
