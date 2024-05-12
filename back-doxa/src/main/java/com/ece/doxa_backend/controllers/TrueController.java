package com.ece.doxa_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.DTO.TrueDTO;
import com.ece.doxa_backend.services.TrueService;

@RestController
@RequestMapping("api/True/")
public class TrueController {

	private final TrueService trueService;

	@Autowired
	public TrueController(final TrueService trueService) {
		this.trueService = trueService;
	}

	@GetMapping
	public ResponseEntity<List<TrueDTO>> getAllTrues() {
		final var trues = trueService.toList();
		return new ResponseEntity<>(trues, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TrueDTO> getTrueById(@PathVariable final Long id) {
		final var comment = trueService.findById(id);
		if (comment != null) {
			return new ResponseEntity<>(comment, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Post/{id}")
	public ResponseEntity<List<TrueDTO>> getTruesByPostId(@PathVariable final Long id) {
		final var trues = trueService.toList();
		return new ResponseEntity<>(trues, HttpStatus.OK);
	}
}
