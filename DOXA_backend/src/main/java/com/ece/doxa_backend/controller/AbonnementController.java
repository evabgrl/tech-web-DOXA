package com.ece.doxa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.model.entity.Abonnement;
import com.ece.doxa_backend.model.entity.User;
import com.ece.doxa_backend.model.service.AbonnementService;
import com.ece.doxa_backend.model.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/abonnement/")
@PreAuthorize("isAuthenticated()")
public class AbonnementController {

	@Autowired
	private AbonnementService abonnementService;

	@Autowired
	private UserService userService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/{id}")
	public Abonnement getAbonnementById(@PathVariable final Long id) {
		return abonnementService.findById(id);
	}

	@GetMapping("/users/{userCheckedId}/{userFollowerId}")
	public Abonnement getAbonnementByUsers(@PathVariable final Long userCheckedId, @PathVariable final Long userFollowerId) {
		final var userChecked = new User();
		final var userFollower = new User();
		return abonnementService.findByUsers(userChecked, userFollower);
	}

	// créer l'abonnement
	@GetMapping("/")
	public List<Abonnement> getAllAbonnements() {
		return abonnementService.toList();
	}

	@PostMapping("/")
	public Abonnement createAbonnement(@RequestBody final Abonnement abonnement) {
		return abonnementService.save(abonnement);
	}

	// supprimer l'abonnement
	@DeleteMapping("/{id}")
	public void deleteAbonnement(@PathVariable final Long id) {
		final var abonnement = abonnementService.findById(id);
		if (abonnement != null) {
			abonnementService.delete(abonnement);
		}
	}

	// récupérer le nombre d'abonnés qu'à un utilisateur

	@GetMapping("/following/{idUser}")
	public Integer getFollowingNumber(@PathVariable final Long idUser) {
		return abonnementService.findFollowingNumber(idUser);
	}
}
