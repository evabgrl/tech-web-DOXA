package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.TrueDAO;
import com.ece.doxa_backend.models.True;

@Service
public class TrueService {

	@Autowired
	TrueDAO repository;

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
