package com.ece.doxa_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ece.doxa_backend.DAO.UserDAO;
import com.ece.doxa_backend.models.User;

@Service("userDetailsService")
public class UserService {

	@Autowired
	UserDAO repository;

	@Transactional(readOnly = true)
	public List<User> toList() {
		return repository.findAll();
	}

	@Transactional
	public User save(final User entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(final User entity) {
		repository.delete(entity);
	}

	@Transactional(readOnly = true)
	public User findById(final Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public User findByUsername(final String username) {
		return repository.findByUsername(username);
	}

	@Transactional
	public User checkIfUserIsPersisted(final User userFound, final User userFromToken) {
		if (!userFound.getUsername().equals(userFromToken.getUsername())) {
			userFound.setUsername(userFromToken.getUsername());
			save(userFound);
		}
		return userFound;
	}

	@Transactional(readOnly = true)
	public List<User> filter(final String username) {
		return repository.filter(username, username);
	}

	@Transactional(readOnly = true)
	public List<User> filterWithoutLimit(final String username) {
		return repository.filterWithoutLimit(username, username);
	}

	@Transactional(readOnly = true)
	public List<User> getFollowers(final Long idUser) {
		return repository.findFollowersByUser(idUser);
	}

	@Transactional(readOnly = true)
	public List<User> getFollowing(final Long idUser) {
		return repository.findFollowingByUser(idUser);
	}

	@Transactional(readOnly = true)
	public Page<User> getByUsername(final String username, final Pageable pageable) {
		return repository.findByUsernameContaining(username, pageable);
	}

	@Transactional(readOnly = true)
	public List<User> getUsersWhoseDeletionDateIsNotNull() {
		return repository.findByDeletionDateIsNotNull();
	}
}
