package com.ece.doxa_backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.DTO.UserDTO;
import com.ece.doxa_backend.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/User/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/list")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		final var users = userService.toList();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@Operation(description = "Receives a user in the request body and, if it exists in the DB, checks if it is updated and returns it, if it does not exist, creates it")
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody final UserDTO user, final Locale locale) {
		var userFound = userService.findByUsername(user.getUsername());
		final Map<String, Object> response = new HashMap<>();
		if (userFound != null) {
			userFound = userService.checkIfUserIsPersisted(userFound, user);
			response.put("message", messageSource.getMessage("appController.login.userFound", null, locale));
			response.put("status", HttpStatus.OK.value());
			response.put("user", userFound);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		userService.save(user);
		response.put("message", messageSource.getMessage("appController.login.userCreated", null, locale));
		response.put("status", HttpStatus.CREATED.value());
		response.put("user", user);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
