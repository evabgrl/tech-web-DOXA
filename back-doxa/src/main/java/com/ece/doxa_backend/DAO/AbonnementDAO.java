package com.ece.doxa_backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ece.doxa_backend.DTO.AbonnementDTO;

public interface AbonnementDAO extends JpaRepository<AbonnementDTO, Long> {

	@Query(value = "SELECT * FROM followerships f WHERE " + "f.id_user_checked = ?1 AND f.id_user_follower = ?2", nativeQuery = true)
	AbonnementDTO findByUsers(Long idUserChecked, Long idUserFollower);

	@Query(value = "SELECT COUNT(*) FROM followerships f WHERE " + "f.id_user_checked = ?", nativeQuery = true)
	Integer findFollowersNumber(Long idUser);

	@Query(value = "SELECT COUNT(*) FROM followerships f WHERE " + "f.id_user_follower = ?", nativeQuery = true)
	Integer findFollowingNumber(Long idUser);
}