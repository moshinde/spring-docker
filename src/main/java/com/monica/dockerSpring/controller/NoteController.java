package com.monica.dockerSpring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.monica.dockerSpring.model.Note;
import com.monica.dockerSpring.service.NoteService;

@RestController
@RequestMapping(path="/api")
public class NoteController {
	
	@Autowired
	public NoteService noteService;
	
	@GetMapping("/")
    public ModelAndView showLoginPage(ModelMap model){
        return new ModelAndView("login");
    }
	
	@PostMapping(path="/")
	public ModelAndView showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        boolean isValidUser = noteService.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return new ModelAndView( "login");
        }

        model.put("name", name);
        model.put("password", password);

        return new ModelAndView( "welcome");
    }
	
	@GetMapping("/notes")
	public ModelAndView listNotes(Model model) {
		
		model.addAttribute("noteList",noteService.listAllNotes());
		
		return new ModelAndView("list");
	}

	@GetMapping("/notes/add")
	public ModelAndView addNote() {
		 return new ModelAndView("add");
	}
	@PostMapping("/notes/add")
	public ModelAndView insertNoteTodb(@ModelAttribute Note note, Model model) {
		noteService.insertNote(note);
		model.addAttribute("message", "Success !!");
		 return new ModelAndView("add");
	}
	
	@GetMapping(path="/notes/update/{id}")
	public ModelAndView getUpdateNote(@PathVariable Long id, Model model) {
		Optional<Note> note=noteService.getById(id);
		model.addAttribute("noteObj",new Note(note.get().getId(), note.get().getTitle(),note.get().getContent()));
		return new ModelAndView("update");
	}
	
	@PostMapping(path="/notes/update/{id}")
	public ModelAndView updateNote(@PathVariable("id") Long id,@ModelAttribute Note note,Model model) {
		noteService.updateNote(id,note);
		 model.addAttribute("noteObj",new Note()); 
		 model.addAttribute("obj", "success !!");
		 return new ModelAndView("update");
		}
	@GetMapping(path="/notes/delete/{id}")
	public ModelAndView getDeleteNote(@PathVariable("id") Long id, Model model) {
		noteService.deleteNote(id);
		model.addAttribute("noteList",noteService.listAllNotes());
		 return new ModelAndView("list");
		}
	
	
	
	
}