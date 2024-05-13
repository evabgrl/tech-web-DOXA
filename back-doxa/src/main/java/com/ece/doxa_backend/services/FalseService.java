package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.FalseDAO;
import com.ece.doxa_backend.models.FalseEntity;

@Service
public class FalseService {

	@Autowired
	FalseDAO repository;

	@Transactional(readOnly = true)
	public List<FalseEntity> toList() {
		return repository.findAll();
	}

	@Transactional
	public FalseEntity save(final FalseEntity entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final FalseEntity entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public FalseEntity findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public FalseEntity findByPostAndUser(final Long idPost, final Long idUser) {
		return repository.findByPostAndUser(idPost, idUser);
	}
}
