package com.ece.doxa_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.models.CommentEntity;
import com.ece.doxa_backend.services.CommentService;

@RestController
@RequestMapping("/Comment")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

	private final CommentService commentService;

	@Autowired
	public CommentController(final CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping
	public ResponseEntity<List<CommentEntity>> getAllComments() {
		final var comments = commentService.toList();
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CommentEntity> createComment(@RequestBody final CommentEntity commentEntity) {
		final var savedComment = commentService.save(commentEntity);
		return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable final Long id) {
		final var comment = commentService.findById(id);
		if (comment != null) {
			commentService.delete(comment);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommentEntity> getCommentById(@PathVariable final Long id) {
		final var comment = commentService.findById(id);
		if (comment != null) {
			return new ResponseEntity<>(comment, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Post/{id}")
	public ResponseEntity<List<CommentEntity>> getCommentsByPostId(@PathVariable final Long id) {
		final var comments = commentService.toList();
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
}
