package com.ece.doxa_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.DTO.AbonnementDTO;
import com.ece.doxa_backend.DTO.UserDTO;
import com.ece.doxa_backend.services.AbonnementService;
import com.ece.doxa_backend.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/Abonnement/")
public class AbonnementController {

	@Autowired
	private AbonnementService abonnementService;

	@Autowired
	private UserService userService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/{id}")
	public AbonnementDTO getAbonnementById(@PathVariable final Long id) {
		return abonnementService.findById(id);
	}

	@GetMapping("/users/{userCheckedId}/{userFollowerId}")
	public AbonnementDTO getAbonnementByUsers(@PathVariable final Long userCheckedId, @PathVariable final Long userFollowerId) {
		final var userChecked = new UserDTO();
		final var userFollower = new UserDTO();
		return abonnementService.findByUsers(userChecked, userFollower);
	}

	// créer l'abonnement
	@GetMapping("/")
	public List<AbonnementDTO> getAllAbonnements() {
		return abonnementService.toList();
	}

	@PostMapping("/")
	public AbonnementDTO createAbonnement(@RequestBody final AbonnementDTO abonnement) {
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
