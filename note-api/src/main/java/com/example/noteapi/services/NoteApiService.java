package com.example.noteapi.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.example.noteapi.dto.Note;
import com.example.noteapi.dto.Notes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoteApiService {

	private static final String PATH = "./all-notes/";

	private JSONParser parser = new JSONParser();  
	
	public boolean createNote(Note noteRequest){
		try {
			String fileName = PATH + noteRequest.getId() + ".json";
			
			if (!noteRequest.getId().matches("^[a-zA-Z0-9_-]{2,20}$")) {
				log.error("INVALID file name.");
				return false;
			}
			FileWriter file = new FileWriter(fileName);
			
			JSONObject contents = new JSONObject();
			contents.put("title", noteRequest.getTitle());
			contents.put("body", noteRequest.getBody());
			
            file.write(contents.toJSONString()); 
            file.flush();
        } catch (IOException e) {
            log.error("Error in inserting note: {}", e.getMessage());
            return false;
        }
		
		return true;
	}
	
	public boolean deleteNote(String id) {
		String fileName = PATH + id + ".json";
		
		try {
			File file = new File(fileName);
			
			if(!file.exists()) {
				log.error("File: {} is not found", fileName);
				return false;
			}
			
			if(file.delete()) {
				log.info("Note successfully deleted.");
				return true;
			} 
			
			return false;
		} catch (Exception e) {
			log.error("Error in creating NOTES directory: {}", e.getMessage());
			return false;
		}
	}
	
	public boolean updateNote(String id, Note note) {
		String fileName = PATH + id + ".json";
		
		try {
			File file = new File(fileName);
			
			if(!file.exists()) {
				log.error("File: {} is not found", fileName);
				return false;
			}
			
			note.setId(id);
			if(!createNote(note)) {
				log.error("Error in updating note");
				return false;
			}
			
			return true;
		} catch (Exception e) {
			log.error("Error in creating NOTES directory: {}", e.getMessage());
			return false;
		}
	}
	
	public Notes retrieveNote(String id) {
		List<Note> notes = new ArrayList<>();
		
		String fileName = PATH + id + ".json";
		
		try {
			File file = new File(fileName);
			
			if(!file.exists()) {
				log.error("File: {} is not found", fileName);
				return null;
			}
			
			Note noteFromFile = parseFromFile(file);
			notes.add(noteFromFile);
			
			return new Notes(notes);
		} catch (Exception e) {
			log.error("Error in creating NOTES directory: {}", e.getMessage());
			return null;
		}
	}
	
	public Notes retrieveAllNotes() {
		List<Note> notes = new ArrayList<>();
		
		File folder = new File("./all-notes");
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			  File file = listOfFiles[i];
			  if (file.isFile() && file.getName().endsWith(".json")) {
			      try {
			  		  notes.add(parseFromFile(file));
			
				  } catch (IOException | ParseException e) {
				      log.error("Error has occured reading all notes: {}",
				    		  e.getMessage());
				  }
			} 
		}
		return new Notes(notes);
	}
	
	private Note parseFromFile(File file) throws ParseException, IOException {
		String content = FileUtils
				  .readFileToString(file, "UTF-8");

		JSONObject json = (JSONObject) parser.parse(content);  
		  
		return Note.builder()
				  .id(file.getName())
				  .title((String) json.get("title"))
				  .body((String) json.get("body"))
				  .build();
	}
}
