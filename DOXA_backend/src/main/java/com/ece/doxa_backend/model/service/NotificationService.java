package com.ece.doxa_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.model.entity.User;
import com.ece.doxa_backend.model.entity.notification.Notification;
import com.ece.doxa_backend.model.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;

	@Transactional(readOnly = true)
	public List<Notification> toList() {
		return repository.findAll();
	}

	@Transactional
	public Notification save(final Notification entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final Notification entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public Notification findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<Notification> findByUser(final User userReceiver) {
		return repository.findByUserReceiver(userReceiver);
	}

	@Transactional
	public void deleteAllByUser(final Long id) {
		repository.deleteAllByUser(id);
	}
}
