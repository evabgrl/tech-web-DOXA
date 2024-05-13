package com.ece.doxa_backend.controllers;

import java.util.ArrayList;
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

import com.ece.doxa_backend.DTO.Abonnement;
import com.ece.doxa_backend.DTO.User;
import com.ece.doxa_backend.models.AbonnementEntity;
import com.ece.doxa_backend.services.AbonnementService;
import com.ece.doxa_backend.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController

@RequestMapping("api/Abonnement/")
@CrossOrigin(origins = "http://localhost:4200")
public class AbonnementController {

	@Autowired
	private AbonnementService abonnementService;

	@Autowired
	private UserService userService;

	@Autowired
	MessageSource messageSource;

	private Abonnement mapToDto(final AbonnementEntity abonnementEntity) {
		final var abonnementDto = new Abonnement();
		abonnementDto.setIdFollowership(abonnementEntity.getIdFollowership());
		// Map other attributes...
		return abonnementDto;
	}

	@GetMapping("/{id}")
	public Abonnement getAbonnementById(@PathVariable final Long id) {
		final var abonnementEntity = abonnementService.findById(id);
		return mapToDto(abonnementEntity);
	}

	@GetMapping("/users/{userCheckedId}/{userFollowerId}")
	public Abonnement getAbonnementByUsers(@PathVariable final Long userCheckedId, @PathVariable final Long userFollowerId) {
		final var userChecked = new User();
		final var userFollower = new User();
		final var abonnementEntity = abonnementService.findByUsers(userChecked, userFollower);
		return mapToDto(abonnementEntity);
	}

	// Créer l'abonnement
	@GetMapping("/")
	public List<Abonnement> getAllAbonnements() {
		final var abonnementEntities = abonnementService.toList();
		final List<Abonnement> abonnementsDto = new ArrayList<>();
		for (final AbonnementEntity abonnementEntity : abonnementEntities) {
			abonnementsDto.add(mapToDto(abonnementEntity));
		}
		return abonnementsDto;
	}

	@PostMapping("/")
	public AbonnementEntity createAbonnement(@RequestBody final AbonnementEntity abonnementEntity) {
		return abonnementService.save(abonnementEntity);
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
