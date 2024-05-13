package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.AbonnementDAO;
import com.ece.doxa_backend.models.Abonnement;

@Service
public class AbonnementService {

	@Autowired
	AbonnementDAO repository;

	@Transactional(readOnly = true)
	public List<Abonnement> toList() {
		return repository.findAll();
	}

	@Transactional
	public Abonnement save(final Abonnement entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final Abonnement entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public Abonnement findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Abonnement findByUsers(final com.ece.doxa_backend.models.User userChecked, final com.ece.doxa_backend.models.User userFollower) {
		return repository.findByUsers(userChecked.getId(), userFollower.getId());
	}

	@Transactional(readOnly = true)
	public Integer findFollowersNumber(final Long idUser) {
		return repository.findFollowersNumber(idUser);
	}

	@Transactional(readOnly = true)
	public Integer findFollowingNumber(final Long idUser) {
		return repository.findFollowingNumber(idUser);
	}
}
