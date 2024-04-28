package com.ece.doxa_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.model.entity.False;
import com.ece.doxa_backend.model.repository.FalseRepository;

@Service
public class FalseService {

	@Autowired
	FalseRepository repository;

	@Transactional(readOnly = true)
	public List<False> toList() {
		return repository.findAll();
	}

	@Transactional
	public False save(final False entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final False entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public False findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public False findByPostAndUser(final Long idPost, final Long idUser) {
		return repository.findByPostAndUser(idPost, idUser);
	}
}
