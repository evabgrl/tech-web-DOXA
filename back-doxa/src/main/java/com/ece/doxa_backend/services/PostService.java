package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.PostDAO;
import com.ece.doxa_backend.models.PostEntity;

@Service
public class PostService {

	@Autowired
	PostDAO repository;

	@Transactional(readOnly = true)
	public List<PostEntity> toList() {
		return repository.findAll();
	}

	@Transactional
	public PostEntity save(final PostEntity entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final PostEntity entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public PostEntity findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Integer countUserPosts(final Long idUser) {
		return repository.countPostsByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<PostEntity> findFollowingFeedByUserId(final Long idUser, final Integer from) {
		return repository.findFollowingFeedByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromFollowingFeedByUserId(final Long idUser) {
		return repository.findLastIdPostFromFollowingFeedByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<PostEntity> findOldFollowingFeedByUserId(final Long idUser, final Integer from) {
		return repository.findOldFollowingFeedByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromOldFollowingFeedByUserId(final Long idUser) {
		return repository.findLastIdPostFromOldFollowingFeedByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<PostEntity> findPostsByUserId(final Long idUser, final Integer from) {
		return repository.findPostsByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromUserPosts(final Long idUser) {
		return repository.findLastIdPostFromPostsByUser(idUser);
	}

	public List<PostEntity> getAllPosts() {
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