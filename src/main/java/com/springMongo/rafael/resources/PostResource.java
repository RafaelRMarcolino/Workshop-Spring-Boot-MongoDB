package com.springMongo.rafael.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springMongo.rafael.domain.Post;
import com.springMongo.rafael.resources.util.URL;
import com.springMongo.rafael.service.PostServices;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	public PostServices services;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> finById(@PathVariable String id) {

		Post obj = services.findId(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> finByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

		text = URL.decoParam(text);
		List<Post> list = services.findByIdTitle(text);
		return ResponseEntity.ok().body(list);
	}

}
