package com.monica.dockerSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monica.dockerSpring.model.Note;
import com.monica.dockerSpring.service.NoteService;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class NoteController {
	
	@Autowired
	public NoteService noteService;
	
	@GetMapping(path="/notes")
	public List<Note> listNotes() {
		return noteService.listAllNotes();
	}

	@PostMapping(path="/addNote",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Note addNote(@RequestBody Note note) {
		 return noteService.insertNote(note);
	}
	
	@DeleteMapping(path="/notes/{id}")
	public String removeNote(@PathVariable Long id) {
		return noteService.deleteNote(id);
	}
	
	@PutMapping(path="/notes")
	public String updateNote(@RequestBody Note note) {
		return noteService.updateNote(note);
		}
	
}