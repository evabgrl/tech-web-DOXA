package com.ece.doxa_backend.controllers;

import java.util.ArrayList;
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

import com.ece.doxa_backend.DTO.Post;
import com.ece.doxa_backend.models.PostEntity;
import com.ece.doxa_backend.services.PostService;

@RestController
@RequestMapping("/api/Post")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

	@Autowired
	private PostService postService;

	private Post mapToDto(final PostEntity postEntity) {

		// Map attributes...
		return new Post();
	}

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {
		final var postEntities = postService.getAllPosts();
		final List<Post> postDtos = new ArrayList<>();
		for (final PostEntity postEntity : postEntities) {
			postDtos.add(mapToDto(postEntity));
		}
		return new ResponseEntity<>(postDtos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable final Long id) {
		final var postEntity = postService.findById(id);
		if (postEntity != null) {
			return new ResponseEntity<>(mapToDto(postEntity), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<PostEntity> createPost(@RequestBody final PostEntity post) {
		final var createdPost = postService.save(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable final PostEntity id) {
		postService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/{postId}/reactions")
	public ResponseEntity<?> reactToPost(@PathVariable final Long postId, @RequestBody final boolean reaction) {
		try {
			postService.reactToPost(postId, reaction);
			return ResponseEntity.ok().build(); // Réaction ajoutée avec succès
		} catch (final Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Erreur lors de l'ajout de la réaction
		}
	}

}
