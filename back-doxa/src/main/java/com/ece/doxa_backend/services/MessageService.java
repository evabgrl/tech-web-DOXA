package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.MessageDAO;
import com.ece.doxa_backend.DTO.MessageDTO;

@Service
public class MessageService {

	@Autowired
	MessageDAO repository;

	@Transactional(readOnly = true)
	public List<MessageDTO> toList() {
		return repository.findAll();
	}

	@Transactional
	public MessageDTO save(final MessageDTO entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final MessageDTO entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public MessageDTO findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<MessageDTO> findByUsers(final Long idUser1, final Long idUser2, final Integer page) {
		return repository.findByUsers(idUser1, idUser2, page);
	}

	@Transactional(readOnly = true)
	public Long findLastIdMessageFromUsers(final Long idUser1, final Long idUser2) {
		return repository.findLastIdMessageFromUsers(idUser1, idUser2);
	}

}
