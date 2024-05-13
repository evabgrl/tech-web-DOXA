package com.ece.doxa_backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.DTO.Message;
import com.ece.doxa_backend.models.MessageEntity;
import com.ece.doxa_backend.services.MessageService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

	@Autowired
	private MessageService messageService;

	private Message mapToDto(final MessageEntity messageEntity) {
		return new Message();
	}

	@GetMapping("/list")
	public ResponseEntity<List<Message>> getAllMessages() {
		final var messageEntities = messageService.toList();
		final List<Message> messageDtos = new ArrayList<>();
		for (final MessageEntity messageEntity : messageEntities) {
			messageDtos.add(mapToDto(messageEntity));
		}
		return new ResponseEntity<>(messageDtos, HttpStatus.OK);
	}

//	@PostMapping("/send")
//	public ResponseEntity<Message> sendMessage(@RequestBody final Message message) {
//		final var savedMessage = messageService.save(message);
//		return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
//	}

	@GetMapping("/get")
	public ResponseEntity<Message> getMessageById(@RequestParam final Long id) {
		final var messageEntity = messageService.findById(id);
		if (messageEntity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(mapToDto(messageEntity), HttpStatus.OK);
	}

}
