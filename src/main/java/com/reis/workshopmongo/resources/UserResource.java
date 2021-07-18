package com.reis.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reis.workshopmongo.dto.UserDTO;
import com.reis.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream()
				.map(x -> new UserDTO(x)).collect(Collectors.toList()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findAll(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(new UserDTO(service.findById(id)));
	}

}
