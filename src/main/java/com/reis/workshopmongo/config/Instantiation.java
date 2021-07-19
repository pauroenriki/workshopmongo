package com.reis.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.reis.workshopmongo.domain.Post;
import com.reis.workshopmongo.domain.User;
import com.reis.workshopmongo.dto.AuthorDTO;
import com.reis.workshopmongo.repository.PostRepository;
import com.reis.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository usuRep;
	
	@Autowired
	private PostRepository postRep;

	@Override
	public void run(String... args) throws Exception {
		usuRep.deleteAll();
		postRep.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		usuRep.saveAll(Arrays.asList(maria, alex, bob));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Post post1 = new Post(null, sdf.parse("18/07/2021"), "Partiu Viajem", 
		"Vou viajar para SP.", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("17/06/2021"), "Bom dia", 
				"Acordei agora.",  new AuthorDTO(maria));
		
		postRep.saveAll(Arrays.asList(post1, post2));
	}

}
