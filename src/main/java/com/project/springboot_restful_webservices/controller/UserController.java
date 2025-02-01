package com.project.springboot_restful_webservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot_restful_webservices.entity.User;
import com.project.springboot_restful_webservices.service.UserService;

import lombok.AllArgsConstructor;

// to make the restful web services as the mvc we need to annotate the controller as the @RestController
//RequestMapping is used to configure the url for all the rest api's in this URL to be used . this avoids configuring the same url for all the different api's in all the different classes there.


@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	// no need to use the autowired annotation because there is only one parameterized constructor so whenever the spring will find it will automatically inject the dependency
	private UserService userService;
	
	//build create User REST API
	//post mapping will handle the Http post request in it 
	// the @RequestBody annotation is responsible for retrieving the HTTP request body(JSON) and automatically converting it to the Java Object
	
	///build create User REST API
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser=userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);	
	}
	
	//build get user by id REST API
	// http://localhost:8080/api/users/id
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
		User user=userService.getUserById(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	//Build get All Users Rest API
	// http://localhost:8080/api/users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		 List<User> users=userService.getAllUsers();
		 return new ResponseEntity<>(users,HttpStatus.OK);	 
	}
	
	//Build Update User REST API
	// @PutMapping annotation is used to map the HTTP PUT request onto specific handler method
	// http://localhost:8080/api/users/1
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
										   @RequestBody	       User user){
		user.setId(userId);
		User updatedUser=userService.updateUser(user);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>("User Deleted Sucessfully", HttpStatus.OK);
	}
		

	
}
