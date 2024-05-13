package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.TrueDAO;
import com.ece.doxa_backend.models.TrueEntity;

@Service
public class TrueService {

	@Autowired
	TrueDAO repository;

	@Transactional(readOnly = true)
	public List<TrueEntity> toList() {
		return repository.findAll();
	}

	@Transactional
	public TrueEntity save(final TrueEntity entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final TrueEntity entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public TrueEntity findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public TrueEntity findByPostAndUser(final Long idPost, final Long idUser) {
		return repository.findByPostAndUser(idPost, idUser);
	}
}
