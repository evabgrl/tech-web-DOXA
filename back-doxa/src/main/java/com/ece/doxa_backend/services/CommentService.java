package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.CommentDAO;
import com.ece.doxa_backend.models.Comment;
import com.ece.doxa_backend.models.Post;

@Service
public class CommentService {

	@Autowired
	CommentDAO repository;

	@Transactional(readOnly = true)
	public List<Comment> toList() {
		return repository.findAll();
	}

	@Transactional
	public Comment save(final Comment entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final Comment entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public Comment findById(final Long id) {
		final var postDTO = new Post();
		postDTO.setIdPost(id);
		return repository.findById(postDTO).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<Comment> toList(final Post post) {
		return repository.findAllByPost(post);
	}
}
