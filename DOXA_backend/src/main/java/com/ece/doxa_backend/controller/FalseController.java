package com.ece.doxa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.model.entity.False;
import com.ece.doxa_backend.model.service.FalseService;

@RestController
@RequestMapping("api/falses/")
public class FalseController {

	private final FalseService falseService;

	@Autowired
	public FalseController(final FalseService falseService) {
		this.falseService = falseService;
	}

	@GetMapping
	public ResponseEntity<List<False>> getAllFalses() {
		final var trues = falseService.toList();
		return new ResponseEntity<>(trues, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<False> getFalseById(@PathVariable final Long id) {
		final var comment = falseService.findById(id);
		if (comment != null) {
			return new ResponseEntity<>(comment, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/post/{id}")
	public ResponseEntity<List<False>> getTruesByPostId(@PathVariable final Long id) {
		final var falses = falseService.toList();
		return new ResponseEntity<>(falses, HttpStatus.OK);
	}
}