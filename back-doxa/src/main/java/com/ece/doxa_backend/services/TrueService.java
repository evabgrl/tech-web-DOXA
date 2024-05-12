package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.TrueDAO;
import com.ece.doxa_backend.DTO.TrueDTO;

@Service
public class TrueService {

	@Autowired
	TrueDAO repository;

	@Transactional(readOnly = true)
	public List<TrueDTO> toList() {
		return repository.findAll();
	}

	@Transactional
	public TrueDTO save(final TrueDTO entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final TrueDTO entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public TrueDTO findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public TrueDTO findByPostAndUser(final Long idPost, final Long idUser) {
		return repository.findByPostAndUser(idPost, idUser);
	}
}
