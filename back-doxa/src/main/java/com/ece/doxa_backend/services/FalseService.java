package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.FalseDAO;
import com.ece.doxa_backend.DTO.FalseDTO;

@Service
public class FalseService {

	@Autowired
	FalseDAO repository;

	@Transactional(readOnly = true)
	public List<FalseDTO> toList() {
		return repository.findAll();
	}

	@Transactional
	public FalseDTO save(final FalseDTO entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final FalseDTO entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public FalseDTO findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public FalseDTO findByPostAndUser(final Long idPost, final Long idUser) {
		return repository.findByPostAndUser(idPost, idUser);
	}
}
