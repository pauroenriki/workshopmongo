package com.reis.workshopmongo.dto;

import java.io.Serializable;

import com.reis.workshopmongo.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	
	public AuthorDTO(User usu) {
		super();
		this.id = usu.getId();
		this.nome = usu.getNome();
	}
}
