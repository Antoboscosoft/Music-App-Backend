package com.example.music_player.service;

import java.util.List;
import java.util.Optional;

import com.example.music_player.model.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(Long id);

	User updateUser(User user, Long id);

	void deleteUser(Long id);

	User getUserByEmail(String email);

	Optional<User> findByUsername(String username);
	Optional<User> findByPassword(String password);

//	boolean checkPassword(String rawPassword, String encodedPassword);
	
}
