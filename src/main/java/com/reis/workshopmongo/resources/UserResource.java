package com.reis.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reis.workshopmongo.domain.Post;
import com.reis.workshopmongo.resources.util.URL;
import com.reis.workshopmongo.services.PostService;

@RestController
@RequestMapping("/posts")
public class UserResource {

	@Autowired
	private PostService service;

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		return ResponseEntity.ok().body(service.findByTitle(text));
	}

}
