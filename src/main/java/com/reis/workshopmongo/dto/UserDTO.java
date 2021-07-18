package com.reis.workshopmongo.dto;

import java.io.Serializable;

import com.reis.workshopmongo.domain.User;

import lombok.Data;

@Data
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String email;
	
    public UserDTO(User obj) {
    	this.id = obj.getId();
    	this.nome = obj.getNome();
    	this.email = obj.getEmail();
    }
}
