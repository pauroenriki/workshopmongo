package com.reis.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reis.workshopmongo.domain.Post;
import com.reis.workshopmongo.domain.User;
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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody User usu) {
		usu = service.insert(usu);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usu.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<UserDTO> update(@RequestBody User user){
		return ResponseEntity.ok(service.update(user));
	}
	
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable("id") String id) {
		User usu = service.findById(id);
		return ResponseEntity.ok().body(usu .getPosts());
	}

}
