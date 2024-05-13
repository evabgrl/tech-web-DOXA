package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.UserDAO;
import com.ece.doxa_backend.models.UserEntity;

@Service("userDetailsService")
public class UserService {

	@Autowired
	UserDAO repository;

	@Transactional(readOnly = true)
	public List<UserEntity> toList() {
		return repository.findAll();
	}

	@Transactional
	public UserEntity save(final UserEntity entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final UserEntity entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public UserEntity findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public UserEntity findByUsername(final String username) {
		return repository.findByUsername(username);
	}

	@Transactional
	public UserEntity checkIfUserIsPersisted(final UserEntity userFound, final UserEntity userFromToken) {
		if (!userFound.getUsername().equals(userFromToken.getUsername())) {
			userFound.setUsername(userFromToken.getUsername());
			save(userFound);
		}
		return userFound;
	}

	@Transactional(readOnly = true)
	public List<UserEntity> filter(final String username) {
		return repository.filter(username, username);
	}

	@Transactional(readOnly = true)
	public List<UserEntity> filterWithoutLimit(final String username) {
		return repository.filterWithoutLimit(username, username);
	}

	@Transactional(readOnly = true)
	public List<UserEntity> getFollowers(final Long idUser) {
		return repository.findFollowersByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<UserEntity> getFollowing(final Long idUser) {
		return repository.findFollowingByUser(idUser);
	}

	@Transactional(readOnly = true)
	public Page<UserEntity> getByUsername(final String username, final Pageable pageable) {
		return repository.findByUsernameContaining(username, pageable);
	}

	@Transactional(readOnly = true)
	public List<UserEntity> getUsersWhoseDeletionDateIsNotNull() {
		return repository.findByDeletionDateIsNotNull();
	}
}
