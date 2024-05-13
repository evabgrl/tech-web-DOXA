package com.ece.doxa_backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.DTO.False;
import com.ece.doxa_backend.models.FalseEntity;
import com.ece.doxa_backend.services.FalseService;

@RestController
@RequestMapping("api/False/")
@CrossOrigin(origins = "http://localhost:4200")
public class FalseController {

	private final FalseService falseService;

	@Autowired
	public FalseController(final FalseService falseService) {
		this.falseService = falseService;
	}

	private False mapToDto(final FalseEntity falseEntity) {

		// Map attributes...
		return new False();
	}

	@GetMapping
	public ResponseEntity<List<False>> getAllFalses() {
		final var falseEntities = falseService.toList();
		final List<False> falseDtos = new ArrayList<>();
		for (final FalseEntity falseEntity : falseEntities) {
			falseDtos.add(mapToDto(falseEntity));
		}
		return new ResponseEntity<>(falseDtos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<False> getFalseById(@PathVariable final Long id) {
		final var falseEntity = falseService.findById(id);
		if (falseEntity != null) {
			return new ResponseEntity<>(mapToDto(falseEntity), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	@GetMapping("/Post/{id}")
//	public ResponseEntity<List<False>> getFalsesByPostId(@PathVariable final Long id) {
//		final var falses = falseService.toList();
//		return new ResponseEntity<>(falses, HttpStatus.OK);
//	}
}
