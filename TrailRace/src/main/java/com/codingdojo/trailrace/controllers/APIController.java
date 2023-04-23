package com.codingdojo.trailrace.controllers;

import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.trailrace.models.LoginUser;
import com.codingdojo.trailrace.models.User;
import com.codingdojo.trailrace.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
public class APIController {
	
	
	//Initialize the Services 
	@Autowired
	private UserService userService;

	
	
	//Find the Logged in User
	@SuppressWarnings("rawtypes")
	@GetMapping("/user")
	public ResponseEntity apiGetUserById(HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = userService.findOne(userId);

		if (currentUser == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No currentUser");
		}
		return ResponseEntity.status(HttpStatus.OK).body(currentUser);
	}

	
	//Register New User
	@SuppressWarnings("rawtypes")
	@PostMapping("/register")
	public ResponseEntity apiRegisterUser(@Valid @RequestBody User newUser, BindingResult result, HttpSession session)
			throws URISyntaxException {
		User createUser = userService.register(newUser, result);
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result.getAllErrors());
		}
		session.setAttribute("user_id", createUser.getId());
		return ResponseEntity.status(HttpStatus.OK).body(createUser);
	}

	//Login User
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity apiLoginUser(@Valid @RequestBody LoginUser user, BindingResult result, HttpSession session)
			throws URISyntaxException {
		User loggedInUser = userService.login(user, result);
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result.getAllErrors());
		}
		session.setAttribute("user_id", loggedInUser.getId());
		return ResponseEntity.status(HttpStatus.OK).body(loggedInUser);

	}

	//LogOut
	@SuppressWarnings("rawtypes")
	@GetMapping("/logout")
	public ResponseEntity deleteUser(HttpSession session) throws URISyntaxException {
		session.invalidate();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
