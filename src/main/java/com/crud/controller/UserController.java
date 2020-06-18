package com.crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.User;
import com.crud.repository.UserRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController{
	
	private final UserRepository userRepository;
	
	
	
	@PostMapping("/users")
	ResponseEntity<User> create(@RequestBody User user){
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/users/{id}")
	ResponseEntity<User> create(@PathVariable("id") Integer id){
		return new ResponseEntity<User>(userRepository.findById(id).orElseGet(null), HttpStatus.OK);
		
	}

	@GetMapping("/users")
	ResponseEntity<User> create(@RequestParam("name")String name){
		return new ResponseEntity<User>(userRepository.findByName(name), HttpStatus.OK);
		
	}
	
	@PutMapping("/users/{id}")
	ResponseEntity<User> create(@RequestBody User user,@PathVariable("id") Integer id){
		User userRef = userRepository.findById(id).orElseGet(null);
		userRef.setName(user.getName());
		userRef.setLname(user.getLname());
		return new ResponseEntity<User>(userRepository.save(userRef), HttpStatus.OK);
		
	}
	}