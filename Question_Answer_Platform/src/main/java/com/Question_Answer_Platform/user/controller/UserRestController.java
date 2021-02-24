package com.Question_Answer_Platform.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.Question_Answer_Platform.user.model.User;
import com.Question_Answer_Platform.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> user =  userService.findAllUser();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/find/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable("name") String name){
		User user = userService.findUserByName(name);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/findUserById/{userId}")
	public ResponseEntity<User> getUserByUserId(@PathVariable("userId") Integer userId){
		User user = userService.findUserByUserId(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = userService.addUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updateUser = userService.updateUser(user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<?> deleteUser(@PathVariable("name") String name){
		userService.deleteUserByName(name);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByUserId/{userId}")
	public ResponseEntity<?> deleteUserByUserId(@PathVariable("userId") Integer userId){
		userService.deleteUserByUserId(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
