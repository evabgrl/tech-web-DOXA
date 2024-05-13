package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.AbonnementDAO;
import com.ece.doxa_backend.models.AbonnementEntity;

@Service
public class AbonnementService {

	@Autowired
	AbonnementDAO repository;

	@Transactional(readOnly = true)
	public List<AbonnementEntity> toList() {
		return repository.findAll();
	}

	@Transactional
	public AbonnementEntity save(final AbonnementEntity abonnement) {
		return repository.save(abonnement);
	}

	@Transactional
	public void delete(final AbonnementEntity entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public AbonnementEntity findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public AbonnementEntity findByUsers(final com.ece.doxa_backend.DTO.User userChecked, final com.ece.doxa_backend.DTO.User userFollower) {
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
