package com.project.springboot_restful_webservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.springboot_restful_webservices.entity.User;
import com.project.springboot_restful_webservices.repository.UserRepository;
import com.project.springboot_restful_webservices.service.UserService;

import lombok.AllArgsConstructor;

//Impl is the implementation 

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	// we are injecting the userRepository in the UserServiceImpl class.
	// if we have the single parameterized constructor then we can use the Spring Bean to implement the and automatically inject that object without using the autowired
	
	private UserRepository userRepository;
	
	// we have implemented the createUser method which will save the data in the restApi
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> optionalUser=userRepository.findById(userId);
		return optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser=userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser=userRepository.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

}
