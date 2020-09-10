package com.sarish.moviecatalogservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarish.moviecatalogservice.models.UserDetails;
import com.sarish.moviecatalogservice.repository.UserRepository;

@RestController
@RequestMapping("/userdetails")
public class UserDetailsResource {
	@Autowired
	UserRepository repository;
	@PostMapping("/add")
	public String addUser(@RequestBody UserDetails userDetails) {
		repository.save(userDetails);
		return "SUCCESS";
	}
	@GetMapping("/")
	public List<UserDetails> allUser() {
		return repository.findAll();
	}
	@RequestMapping("/{userId}")
	public UserDetails getUserById(@PathVariable("userId") int userId) {
		return repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Not Found"));
	}
	
	
}
