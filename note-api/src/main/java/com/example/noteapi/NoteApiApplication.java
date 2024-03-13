package com.example.noteapi;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class NoteApiApplication {

	public static void main(String[] args) {
		log.info("NOTE-API APPLICATION STARTING");
		
		if(createDirectory()) {
			SpringApplication.run(NoteApiApplication.class, args);
		} else {
			log.error("Error in running application.");
		}
	}

	private static boolean createDirectory() {
		try {
			File noteDirectory = new File("./all-notes");
			
			if(!noteDirectory.exists()) {
				noteDirectory.mkdir();
			}
		} catch (Exception e) {
			log.error("Error in creating NOTES directory: {}", e.getMessage());
			return false;
		}
		return true;
	}

}
