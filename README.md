
## OTA Initial Coding Challenge

### Objective
Develop a simple backend for a note-taking application using either Micronaut, Spring-boot, or something similar.

### Project Description
Create a RESTful API that allows users to create, retrieve, update, and delete notes. Each note can consist of a title and a body.


### Specific Requirements
1. API Endpoints:
· POST /notes: Create a new note.
· GET /notes: Retrieve all notes.
· GET /notes/:id: Retrieve a specific note by ID.
· PUT /notes/:id: Update a specific note.
· DELETE /notes/:id: Delete a specific note.
2. Data Storage: Use an in-memory array or a simple file-based solution to store notes.
3. Data Validation: Validate input data for creating and updating notes.
4. Error Handling: Basic error handling for common scenarios (e.g., note not found).


## How to run (you need mvn installed and jre and/or jdk)

1. Navigate to folder containing pom.xml
2. type command in terminal: mvn spring-boot:run
