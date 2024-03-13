package com.example.noteapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.noteapi.dto.Note;
import com.example.noteapi.dto.Notes;

@Service
public class NoteApiService {

	public boolean createNote(Note note) {
		boolean success = false;
		
		
		return success;
	}
	
	public boolean deleteNote(Note note) {
		boolean success = false;
		
		
		return success;
	}
	
	public Notes retrieveNote(Note note) {
		List<Note> notes = new ArrayList<>();
		
		
		return new Notes(notes);
	}
	
	public boolean updateNote(Note note) {
		boolean success = false;
		
		return success;
	}
	
	public Notes retrieveAllNotes() {
		List<Note> notes = new ArrayList<>();
		
		
		return new Notes(notes);
	}
}
