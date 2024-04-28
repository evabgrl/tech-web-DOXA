package com.ece.doxa_backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ece.doxa_backend.model.entity.Abonnement;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {

	@Query(value = "SELECT * FROM followerships f WHERE " + "f.id_user_checked = ?1 AND f.id_user_follower = ?2", nativeQuery = true)
	Abonnement findByUsers(Long idUserChecked, Long idUserFollower);

	@Query(value = "SELECT COUNT(*) FROM followerships f WHERE " + "f.id_user_checked = ?", nativeQuery = true)
	Integer findFollowersNumber(Long idUser);

	@Query(value = "SELECT COUNT(*) FROM followerships f WHERE " + "f.id_user_follower = ?", nativeQuery = true)
	Integer findFollowingNumber(Long idUser);
}