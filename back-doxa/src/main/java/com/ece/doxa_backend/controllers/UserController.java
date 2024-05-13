package com.ece.doxa_backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.DTO.User;
import com.ece.doxa_backend.models.UserEntity;
import com.ece.doxa_backend.services.UserService;

@RestController
@RequestMapping("api/User/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	MessageSource messageSource;

	private User mapToDto(final UserEntity userEntity) {

		// Map attributes...
		return new User();
	}

	@GetMapping("/list")
	public ResponseEntity<List<User>> getAllUsers() {
		final var userEntities = userService.toList();
		final List<User> userDtos = new ArrayList<>();
		for (final UserEntity userEntity : userEntities) {
			userDtos.add(mapToDto(userEntity));
		}
		return new ResponseEntity<>(userDtos, HttpStatus.OK);
	}

//	@Operation(description = "Receives a user in the request body and, if it exists in the DB, checks if it is updated and returns it, if it does not exist, creates it")
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody final User user, final Locale locale) {
//		var userFound = userService.findByUsername(user.getUsername());
//		final Map<String, Object> response = new HashMap<>();
//		if (userFound != null) {
//			userFound = userService.checkIfUserIsPersisted(userFound, user);
//			response.put("message", messageSource.getMessage("appController.login.userFound", null, locale));
//			response.put("status", HttpStatus.OK.value());
//			response.put("user", userFound);
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		}
//		userService.save(user);
//		response.put("message", messageSource.getMessage("appController.login.userCreated", null, locale));
//		response.put("status", HttpStatus.CREATED.value());
//		response.put("user", user);
//		return new ResponseEntity<>(response, HttpStatus.CREATED);
//	}
}
