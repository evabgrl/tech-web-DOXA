package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.MessageDAO;
import com.ece.doxa_backend.models.MessageEntity;

@Service
public class MessageService {

	@Autowired
	MessageDAO repository;

	@Transactional(readOnly = true)
	public List<MessageEntity> toList() {
		return repository.findAll();
	}

	@Transactional
	public MessageEntity save(final MessageEntity entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final MessageEntity entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public MessageEntity findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<MessageEntity> findByUserTransmitterIdAndUserReceiverId(final Long userTransmitterId, final Long userReceiverId) {
		return repository.findByUserTransmitterIdAndUserReceiverId(userTransmitterId, userReceiverId);
	}

	@Transactional(readOnly = true)
	public Long findLastIdMessageFromUsers(final Long idUser1, final Long idUser2) {
		return repository.findLastIdMessageFromUsers(idUser1, idUser2);
	}

}
