package com.ece.doxa_backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ece.doxa_backend.DTO.AbonnementDTO;

public interface AbonnementDAO extends JpaRepository<AbonnementDTO, Long> {

	@Query(value = "SELECT * FROM Abonnement a WHERE " + "a.userChecked.idUser = ?1 AND a.userFollower.idUser = ?2", nativeQuery = true)
	AbonnementDTO findByUsers(Long idUserChecked, Long idUserFollower);

	@Query(value = "SELECT COUNT(*) FROM Abonnement a WHERE " + "a.userChecked.idUser = ?", nativeQuery = true)
	Integer findFollowersNumber(Long idUser);

	@Query(value = "SELECT COUNT(*) FROM Abonnement a WHERE " + "a.userFollower.idUser = ?", nativeQuery = true)
	Integer findFollowingNumber(Long idUser);
}