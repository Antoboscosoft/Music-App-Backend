package com.example.music_player.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.music_player.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	Optional<User> findByUsername(String username);
	Optional<User> findByPassword(String password);
}
