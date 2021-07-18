package com.reis.workshopmongo.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	private String email;

	public User(String id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

}
