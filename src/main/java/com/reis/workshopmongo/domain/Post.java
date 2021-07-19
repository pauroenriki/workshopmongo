package com.reis.workshopmongo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.reis.workshopmongo.dto.AuthorDTO;

import lombok.Data;

@Document
@Data
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
	
	
}
