package com.example.music_player.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.music_player.model.User;
import com.example.music_player.service.UserService;

@RestController
@RequestMapping("/users/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("createuser")
	public String createUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return "User created successfully!";
		} catch (IllegalArgumentException e) {
			return "This email is already registered...";
		}
	}

	@GetMapping("getalluser")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PutMapping("{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.updateUser(user, id);
	}

	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
//	@PostMapping("login")
//	public String loginUser(@RequestBody User loginDetails) {
//		User user = userService.getUserByEmail(loginDetails.getEmail());
//		if(user != null && userService.checkPassword(loginDetails.getPassword(), user.getPassword())) {
//			return "Login successful";
//		} else {
//			return "Invalid email or password";
//		}
//	}

	@PostMapping("login")
	public ResponseEntity<Object> login(@RequestBody User loginRequest){
		
		Optional<User> user = userService.findByUsername(loginRequest.getUsername());
		System.out.println("loginRequest" + loginRequest);
		if(user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
		  // You might want to return more details or a token here
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.status(401).body("Invalid username or password");
		}
	}
	
	
}
