package com.ece.doxa_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.model.entity.Post;
import com.ece.doxa_backend.model.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository repository;

	@Transactional(readOnly = true)
	public List<Post> toList() {
		return repository.findAll();
	}

	@Transactional
	public Post save(final Post entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final Post entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public Post findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Integer countUserPosts(final Long idUser) {
		return repository.countPostsByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<Post> findFollowingFeedByUserId(final Long idUser, final Integer from) {
		return repository.findFollowingFeedByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromFollowingFeedByUserId(final Long idUser) {
		return repository.findLastIdPostFromFollowingFeedByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<Post> findOldFollowingFeedByUserId(final Long idUser, final Integer from) {
		return repository.findOldFollowingFeedByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromOldFollowingFeedByUserId(final Long idUser) {
		return repository.findLastIdPostFromOldFollowingFeedByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<Post> findTrendFeed(final Integer from) {
		return repository.findTrendFeed(from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromTrendFeed(final Long idUser) {
		return repository.findLastIdPostFromTrendFeed(idUser);
	}

	@Transactional(readOnly = true)
	public List<Post> findPostsByUserId(final Long idUser, final Integer from) {
		return repository.findPostsByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromUserPosts(final Long idUser) {
		return repository.findLastIdPostFromPostsByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<Post> findLikedPostsByUserId(final Long idUser, final Integer from) {
		return repository.findLikedPostsByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromLikedPostsUser(final Long idUser) {
		return repository.findLastIdPostFromLikedPostsByUser(idUser);
	}

	public List<Post> getAllPosts() {
		return repository.findAll();
	}

	public void reactToPost(final Long postId, final boolean reaction) {
		final var post = repository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
		if (reaction) {

			post.setReaction(true);
		} else {
			post.setReaction(false);
		}
		repository.save(post);
	}
}