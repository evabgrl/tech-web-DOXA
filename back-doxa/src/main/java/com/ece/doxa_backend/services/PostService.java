package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.PostDAO;
import com.ece.doxa_backend.DTO.PostDTO;

@Service
public class PostService {

	@Autowired
	PostDAO repository;

	@Transactional(readOnly = true)
	public List<PostDTO> toList() {
		return repository.findAll();
	}

	@Transactional
	public PostDTO save(final PostDTO entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final PostDTO entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public PostDTO findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Integer countUserPosts(final Long idUser) {
		return repository.countPostsByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<PostDTO> findFollowingFeedByUserId(final Long idUser, final Integer from) {
		return repository.findFollowingFeedByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromFollowingFeedByUserId(final Long idUser) {
		return repository.findLastIdPostFromFollowingFeedByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<PostDTO> findOldFollowingFeedByUserId(final Long idUser, final Integer from) {
		return repository.findOldFollowingFeedByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromOldFollowingFeedByUserId(final Long idUser) {
		return repository.findLastIdPostFromOldFollowingFeedByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<PostDTO> findPostsByUserId(final Long idUser, final Integer from) {
		return repository.findPostsByUser(idUser, from);
	}

	@Transactional(readOnly = true)
	public Long findLastIdPostFromUserPosts(final Long idUser) {
		return repository.findLastIdPostFromPostsByUser(idUser);
	}

	public List<PostDTO> getAllPosts() {
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