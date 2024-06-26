package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.models.UserEntity;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);

	@Query(value = """
			SELECT * FROM User u WHERE\s\
			u.username NOT LIKE CONCAT('%',?2,'%') AND\s\
			LIMIT 0,5""", nativeQuery = true)
	List<UserEntity> filter(String name, String keycloakUsername);

	@Query(value = """
			SELECT * FROM User u WHERE\s\
			u.username NOT LIKE CONCAT('%',?2,'%') """, nativeQuery = true)
	List<UserEntity> filterWithoutLimit(String name, String keycloakUsername);

	@Query(value = """
			SELECT u.* FROM User u\s\
			INNER JOIN Abonnement f ON u.id_user = f.id_user_follower\s\
			WHERE f.id_user_checked = ?""", nativeQuery = true)
	List<UserEntity> findFollowersByUser(Long idUser);

	@Query(value = """
			SELECT u.* FROM User u\s\
			INNER JOIN Abonnement f ON u.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?""", nativeQuery = true)
	List<UserEntity> findFollowingByUser(Long idUser);

	Page<UserEntity> findByUsernameContaining(String username, Pageable pageable);

	@Query(value = "SELECT * FROM User WHERE deletion_date IS NOT NULL "
			+ "AND DATEDIFF(current_timestamp(), deletion_date) >= 14", nativeQuery = true)
	List<UserEntity> findByDeletionDateIsNotNull();
}
