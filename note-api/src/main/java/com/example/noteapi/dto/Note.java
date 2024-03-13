package com.example.noteapi.dto;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Note {
	
	@NotNull(message = "ID must not be null.")
	private String id;
	
	@NotBlank(message = "Title must not be blank.")
	private String title;
	
	@NotBlank(message = "Body must not be blank.")
	private String body;
}
