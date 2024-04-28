package com.ece.doxa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.model.entity.Message;
import com.ece.doxa_backend.model.service.MessageService;

@RestController
@RequestMapping("/api/messages")
@PreAuthorize("isAuthenticated()")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/list")
	public ResponseEntity<List<Message>> getAllMessages() {
		final var messages = messageService.toList();
		return new ResponseEntity<>(messages, HttpStatus.OK);
	}

	@PostMapping("/send")
	public ResponseEntity<Message> sendMessage(@RequestBody final Message message) {
		final var savedMessage = messageService.save(message);
		return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<Message> getMessageById(@RequestParam final Long id) {
		final var message = messageService.findById(id);
		if (message == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
