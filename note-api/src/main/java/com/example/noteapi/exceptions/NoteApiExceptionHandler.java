package com.example.noteapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class NoteApiExceptionHandler {
	
	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<String> handleValidationException(
			IllegalArgumentException ex){
		log.info("Argument error has occurred {}", ex.getMessage());
		
		return new ResponseEntity<>("File is not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<String> handleArgumentNotValidException(
			MethodArgumentNotValidException mnv){
		log.info("Validation error has occurred {}", mnv.getMessage());
		
		return new ResponseEntity<>("One or more fields are not "
				+ "valid/missing from request", HttpStatus.BAD_REQUEST);
	}
	
	
}
