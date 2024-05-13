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

import com.ece.doxa_backend.DTO.True;
import com.ece.doxa_backend.models.TrueEntity;
import com.ece.doxa_backend.services.TrueService;

@RestController
@RequestMapping("api/True/")
@CrossOrigin(origins = "http://localhost:4200")
public class TrueController {

	private final TrueService trueService;

	@Autowired
	public TrueController(final TrueService trueService) {
		this.trueService = trueService;
	}

	private True mapToDto(final TrueEntity trueEntity) {

		// Map attributes...
		return new True();
	}

	@GetMapping
	public ResponseEntity<List<True>> getAllTrues() {
		final var trueEntities = trueService.toList();
		final List<True> trueDtos = new ArrayList<>();
		for (final TrueEntity trueEntity : trueEntities) {
			trueDtos.add(mapToDto(trueEntity));
		}
		return new ResponseEntity<>(trueDtos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<True> getTrueById(@PathVariable final Long id) {
		final var trueEntity = trueService.findById(id);
		if (trueEntity != null) {
			return new ResponseEntity<>(mapToDto(trueEntity), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	@GetMapping("/Post/{id}")
//	public ResponseEntity<List<True>> getTruesByPostId(@PathVariable final Long id) {
//		final var trues = trueService.toList();
//		return new ResponseEntity<>(trues, HttpStatus.OK);
//	}
}
