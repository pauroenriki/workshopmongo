package com.reis.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String text;
	private Date data;
	private AuthorDTO author;
	public CommentDTO(String text, Date data, AuthorDTO author) {
		super();
		this.text = text;
		this.data = data;
		this.author = author;
	}
	
	
}
