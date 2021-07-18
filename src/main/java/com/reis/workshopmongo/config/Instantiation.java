package com.reis.workshopmongo.config;

import com.reis.workshopmongo.repository.UserRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.reis.workshopmongo.domain.User;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository usuRep;

	@Override
	public void run(String... args) throws Exception {
		usuRep.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		usuRep.saveAll(Arrays.asList(maria, alex, bob));
	}

}
