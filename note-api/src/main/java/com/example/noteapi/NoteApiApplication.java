package com.example.noteapi;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class NoteApiApplication {

	public static void main(String[] args) {
		log.info("NOTE-API APPLICATION STARTING");
		if(createJsonFile()) {
			SpringApplication.run(NoteApiApplication.class, args);
		} else {
			log.error("error in running application");
		}
	}

	private static boolean createJsonFile() {
		try {
			File noteDirectory = new File("NOTES.json");
			
			if(!noteDirectory.exists()) {
				noteDirectory.createNewFile();
			}
		} catch (Exception e) {
			log.error("Error in creating NOTES directory: {}", e.getMessage());
			return false;
		}
		return true;
	}

}
