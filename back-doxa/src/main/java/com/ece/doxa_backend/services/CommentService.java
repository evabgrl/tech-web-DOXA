package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.CommentDAO;
import com.ece.doxa_backend.models.CommentEntity;
import com.ece.doxa_backend.models.PostEntity;

@Service
public class CommentService {

	@Autowired
	CommentDAO repository;

	@Transactional(readOnly = true)
	public List<CommentEntity> toList() {
		return repository.findAll();
	}

	@Transactional
	public CommentEntity save(final CommentEntity entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final CommentEntity entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public CommentEntity findById(final Long id) {
		final var postDTO = new PostEntity();
		postDTO.setIdPost(id);
		return repository.findById(postDTO).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<CommentEntity> toList(final PostEntity post) {
		return repository.findAllByPost(post);
	}
}
