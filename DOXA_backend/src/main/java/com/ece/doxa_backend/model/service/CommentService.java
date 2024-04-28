package com.ece.doxa_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.model.entity.Comment;
import com.ece.doxa_backend.model.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository repository;

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
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<Comment> toList(final Long idPost) {
		return repository.findAll(idPost);
	}
}
