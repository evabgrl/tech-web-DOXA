package com.ece.doxa_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.model.entity.True;
import com.ece.doxa_backend.model.repository.TrueRepository;

@Service
public class TrueService {

	@Autowired
	TrueRepository repository;

	@Transactional(readOnly = true)
	public List<True> toList() {
		return repository.findAll();
	}

	@Transactional
	public True save(final True entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final True entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public True findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public True findByPostAndUser(final Long idPost, final Long idUser) {
		return repository.findByPostAndUser(idPost, idUser);
	}
}
