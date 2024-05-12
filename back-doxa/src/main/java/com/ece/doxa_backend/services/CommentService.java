package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.CommentDAO;
import com.ece.doxa_backend.DTO.CommentDTO;
import com.ece.doxa_backend.DTO.PostDTO;

@Service
public class CommentService {

	@Autowired
	CommentDAO repository;

	@Transactional(readOnly = true)
	public List<CommentDTO> toList() {
		return repository.findAll();
	}

	@Transactional
	public CommentDTO save(final CommentDTO entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final CommentDTO entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public CommentDTO findById(final Long id) {
		final var postDTO = new PostDTO();
		postDTO.setIdPost(id);
		return repository.findById(postDTO).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<CommentDTO> toList(final PostDTO post) {
		return repository.findAllByPost(post);
	}
}
