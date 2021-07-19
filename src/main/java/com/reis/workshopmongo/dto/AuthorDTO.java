package com.reis.workshopmongo.dto;

import com.reis.workshopmongo.domain.User;

import lombok.Data;

@Data
public class AuthorDTO {
	
	private String id;
	private String nome;
	
	public AuthorDTO(User usu) {
		super();
		this.id = usu.getId();
		this.nome = usu.getNome();
	}
}
