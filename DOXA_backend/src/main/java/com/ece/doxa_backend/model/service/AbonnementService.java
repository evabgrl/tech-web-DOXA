package com.ece.doxa_backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.model.entity.Abonnement;
import com.ece.doxa_backend.model.entity.User;
import com.ece.doxa_backend.model.repository.AbonnementRepository;

@Service
public class AbonnementService {

	@Autowired
	AbonnementRepository repository;

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
	public Abonnement findByUsers(final User userChecked, final User userFollower) {
		return repository.findByUsers(userChecked.getIdUser(), userFollower.getIdUser());
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
