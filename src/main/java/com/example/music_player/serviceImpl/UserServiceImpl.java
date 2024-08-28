package com.example.music_player.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.music_player.model.User;
import com.example.music_player.repository.UserRepository;
import com.example.music_player.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

//	@Autowired
//    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new IllegalArgumentException("Email already registered!");
		}
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(id).orElse(null);
		if(existingUser !=null) {
			existingUser.setFullName(user.getFullName());
			existingUser.setEmail(user.getEmail());
//			existingUser.setMobileNumber(user.getMobileNumber());
//			existingUser.setGender(user.getGender());
//			existingUser.setPreferredLanguage(user.getPreferredLanguage());
			existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
//			existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.saveAndFlush(existingUser);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
//		return Optional.empty();
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findByPassword(String password) {
		// TODO Auto-generated method stub
//		return Optional.empty();
		return userRepository.findByPassword(password);
	}

//	@Override
//	public boolean checkPassword(String rawPassword, String encodedPassword) {
//		// TODO Auto-generated method stub
//		return passwordEncoder.matches(rawPassword, encodedPassword);
//	}

}
