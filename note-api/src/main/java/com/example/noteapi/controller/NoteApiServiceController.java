package com.example.noteapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.noteapi.dto.Note;
import com.example.noteapi.dto.Notes;
import com.example.noteapi.services.NoteApiService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/notes")
public class NoteApiServiceController {
	
	@Autowired
	private NoteApiService noteApiService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createNote(
			@Valid @RequestBody Note note){
		log.info("Create Note with id={} and title={}", note.getId(), note.getTitle());
		boolean success = noteApiService.createNote(note);
		
		if(success) {
			return new ResponseEntity<>("Note created.", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Something went wrong in note creation.",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Notes> retreiveAllNotes(){
		log.info("Getting all notes.");
		
		Notes notes = noteApiService.retrieveAllNotes();
		
		return new ResponseEntity<>(notes, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Notes> retrieveNote(@RequestParam String id){
		log.info("Retrieving content of id: {}", id);
		
		Notes notes = noteApiService.retrieveNote(id);
		
		return new ResponseEntity<>(notes, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteNote(){
		
		return null;
	}
}
