package com.ece.doxa_backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.model.entity.User;
import com.ece.doxa_backend.model.service.UserService;
import com.ece.doxa_backend.utility_classes.JsonUserAppMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("api/app/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/list")
	public ResponseEntity<List<User>> getAllUsers() {
		final var users = userService.toList();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@Operation(description = "Receives a user in the request body and, if it exists in the DB, checks if it is updated and returns it, if it does not exist, creates it")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = JsonUserAppMessage.class)) }),
			@ApiResponse(responseCode = "201", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = JsonUserAppMessage.class)) }) })
	@PostMapping("/login")
	@PreAuthorize("isAuthenticated() and hasRole('user')")
	public ResponseEntity<?> login(@RequestBody final User user, final Locale locale) {
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
