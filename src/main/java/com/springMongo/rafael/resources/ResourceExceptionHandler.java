package com.springMongo.rafael.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.springMongo.rafael.resources.exception.StandardError;
import com.springMongo.rafael.service.excepion.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Nao encontrado", e.getMessage(), request.getRequestURI()); 
		return ResponseEntity.status(status).body(error);
		
	}
	
	
}
