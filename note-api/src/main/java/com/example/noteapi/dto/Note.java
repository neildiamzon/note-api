package com.example.noteapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Note {
	
	private String id;
	private String title;
	private String body;
}
