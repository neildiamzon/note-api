package com.example.noteapi.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.noteapi.dto.Note;
import com.example.noteapi.dto.Notes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoteApiService {

	public boolean createNote(Note note) throws Exception {
		JSONObject noteJson = new JSONObject();
		noteJson.put("id", note.getId());
		noteJson.put("title", note.getTitle());
		noteJson.put("body", note.getBody());
		
		JSONArray noteList = new JSONArray();
		
		noteList.add(noteJson);
		
		try (FileWriter file = new FileWriter("NOTES.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(noteList.toJSONString()); 
            file.flush();
        } catch (IOException e) {
            log.error("Error in inserting note: {}", e.getMessage());
            return false;
        }
		
		return true;
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
