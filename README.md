
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


## How to start application (you need mvn installed and jre and/or jdk)

1. Clone repo into your local 
2. Navigate to folder containing pom.xml
3. type command in terminal: mvn spring-boot:run

## How to use application 
Pre-requisite: Postman or any similar application

URL starts with "localhost:8080" as port 8080 is the default
Refer to images below for sample payload:


1. Sample image below for POST /notes -- adding a new note in the list:
   <img width="852" alt="image" src="https://github.com/neildiamzon/note-api/assets/42030059/5ba59894-a1f8-4792-b050-80ea430e776a">
2. Sample image below for GET /notes -- getting all the notes:
   <img width="844" alt="image" src="https://github.com/neildiamzon/note-api/assets/42030059/282c3a33-dbd0-4bdb-af0d-20b21c357f83">
3. Sample image below for PUT /notes/id -- updating a specific note:
   <img width="855" alt="image" src="https://github.com/neildiamzon/note-api/assets/42030059/81a573e8-93ec-449d-8c71-ebe140408575">
4. Sample image below for GET /notes/id -- retrieving a specific note:
  <img width="845" alt="image" src="https://github.com/neildiamzon/note-api/assets/42030059/8bc971c0-1f5b-4486-afaf-afd1c243eb6f">
5. Sample image below for DELETE /notes/id -- deleting a specific note:
  <img width="853" alt="image" src="https://github.com/neildiamzon/note-api/assets/42030059/1f8e6d24-6c14-4f5d-82c4-2aa58c5909e1">


## Sample errors

1. Missing id in POST /notes:
   <img width="853" alt="image" src="https://github.com/neildiamzon/note-api/assets/42030059/5fd41797-9805-4437-848c-610eef7be413">

2. Note not found in DELETE /notes:
   <img width="849" alt="image" src="https://github.com/neildiamzon/note-api/assets/42030059/bddcb30a-f5ae-4f77-a71b-2e6ec3c8bdc2">






  
