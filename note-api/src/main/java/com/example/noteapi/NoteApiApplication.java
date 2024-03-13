package com.example.noteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class NoteApiApplication {

	public static void main(String[] args) {
		log.info("NOTE-API APPLICATION STARTING");
		SpringApplication.run(NoteApiApplication.class, args);
	}

}
