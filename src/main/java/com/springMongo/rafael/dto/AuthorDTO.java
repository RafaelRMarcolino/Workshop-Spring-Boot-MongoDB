package com.springMongo.rafael.dto;

import java.io.Serializable;

import com.springMongo.rafael.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	
	public AuthorDTO() {
		
	}	

	public AuthorDTO(User author) {
		super();
		name = author.getName();
		email = author.getEmail();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
