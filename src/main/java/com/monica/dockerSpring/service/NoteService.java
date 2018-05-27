package com.monica.dockerSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	public Optional<Note> getById(Long id) {
		return noteRepository.findById(id);
	}
	public Note insertNote(Note note) {
		return noteRepository.save(note);
	}
	
	public String deleteNote(Long id) {
		noteRepository.deleteById(id);
		return "deleted";
	}
	
	public void updateNote(Long id,Note newNote) {
		
	 noteRepository.updateNote(id, newNote.getTitle(), newNote.getContent());
		
	}
	
	public boolean validateUser(String userid, String password) {
        // in28minutes, dummy
        return userid.equalsIgnoreCase("moshinde")
                && password.equalsIgnoreCase("dummy");
    }
}
