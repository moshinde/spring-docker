package com.monica.dockerSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monica.dockerSpring.model.Note;
import com.monica.dockerSpring.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	public NoteRepository noteRepository;
	
	
	public List<Note> listAllNotes(){
		return (List<Note>) noteRepository.findAll();
	}
	
	public Note insertNote(Note note) {
		return noteRepository.save(note);
	}
	
	public String deleteNote(Long id) {
		noteRepository.deleteById(id);
		return "deleted";
	}
	
	public String updateNote(Note newNote) {
		noteRepository.deleteById(newNote.getId());
		noteRepository.save(newNote);
		return "updated";
	}
}
