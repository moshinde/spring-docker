package com.monica.dockerSpring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)
public class Note implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = true)
    private Long id;

    @NotBlank
    @Column(updatable = true)
    private String title;
    
    @NotBlank
    @Column(updatable = true)
    private String content;

    @Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

	public Note(Long id, @NotBlank String title, @NotBlank String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public Note() {
		super();
	}

	public void setContent(String content) {
		this.content = content;
	}
    
}
