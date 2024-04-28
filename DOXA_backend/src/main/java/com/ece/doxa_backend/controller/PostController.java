package com.ece.doxa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.model.entity.Post;
import com.ece.doxa_backend.model.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	// Endpoint pour récupérer tous les posts
	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {
		final var posts = postService.getAllPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	// Endpoint pour récupérer un post par son ID
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") final Long id) {
		final var post = postService.findById(id);
		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Endpoint pour enregistrer un nouveau post
	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody final Post post) {
		final var createdPost = postService.save(post);
		return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
	}

	// Endpoint pour supprimer un post
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable("id") final Post id) {
		postService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{postId}/response/{userResponse}")
	public String checkUserResponse(@PathVariable final Long postId, @PathVariable final boolean userResponse) {
		// Récupérer le post par son ID
		final var post = postService.findById(postId);

		// Vérifier si la réponse de l'utilisateur correspond à la valeur boolean du
		// post
		if (post == null) {
			return "Post not found!";
		}
		if (userResponse == post.isTrue()) {
			return "Correct!";
		}
		return "Incorrect!";
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
