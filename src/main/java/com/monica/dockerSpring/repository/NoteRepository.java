package com.monica.dockerSpring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.monica.dockerSpring.model.Note;
@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{



}
