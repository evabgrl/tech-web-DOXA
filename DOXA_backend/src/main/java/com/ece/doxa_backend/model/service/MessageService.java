package com.ece.doxa_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.model.entity.Message;
import com.ece.doxa_backend.model.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository repository;

	@Transactional(readOnly = true)
	public List<Message> toList() {
		return repository.findAll();
	}

	@Transactional
	public Message save(final Message entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final Message entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public Message findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<Message> findByUsers(final Long idUser1, final Long idUser2, final Integer page) {
		return repository.findByUsers(idUser1, idUser2, page);
	}

	@Transactional(readOnly = true)
	public Long findLastIdMessageFromUsers(final Long idUser1, final Long idUser2) {
		return repository.findLastIdMessageFromUsers(idUser1, idUser2);
	}
}