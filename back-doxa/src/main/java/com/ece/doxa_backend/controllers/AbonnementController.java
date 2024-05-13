package com.ece.doxa_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.models.Abonnement;
import com.ece.doxa_backend.models.User;
import com.ece.doxa_backend.services.AbonnementService;
import com.ece.doxa_backend.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController

@RequestMapping("api/Abonnement/")
@CrossOrigin(origins = "http://localhost:4200")
public class AbonnementController {

	private final AbonnementService abonnementService;

	@Autowired
	public AbonnementController(final AbonnementService abonnementService) {
		this.abonnementService = abonnementService;
	}

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
