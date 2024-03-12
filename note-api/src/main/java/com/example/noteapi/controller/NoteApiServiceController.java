package com.example.noteapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.noteapi.dto.Note;

@RestController
@RequestMapping("/notes")
public class NoteApiServiceController {

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createNote(
			@RequestBody Note note){
		boolean success = false;
		
		
		return ResponseEntity.ok("Create Note completed with errors: " + success);
	}
}
