package com.monica.dockerSpring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monica.dockerSpring.model.Note;
@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Note n set n.title=:title, n.content=:content where n.id=:id")
	public void updateNote(@Param("id") Long id, @Param("title") String title, @Param("content") String content );
}
