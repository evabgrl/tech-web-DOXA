package com.ece.doxa_backend.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	@Query(value = """
			SELECT * FROM users u WHERE\s\
			u.username NOT LIKE CONCAT('%',?2,'%') AND\s\
			LIMIT 0,5""", nativeQuery = true)
	List<User> filter(String name, String keycloakUsername);

	@Query(value = """
			SELECT * FROM users u WHERE\s\
			u.username NOT LIKE CONCAT('%',?2,'%') """, nativeQuery = true)
	List<User> filterWithoutLimit(String name, String keycloakUsername);

	@Query(value = """
			SELECT u.* FROM users u\s\
			INNER JOIN abonnement f ON u.id_user = f.id_user_follower\s\
			WHERE f.id_user_checked = ?""", nativeQuery = true)
	List<User> findFollowersByUser(Long idUser);

	@Query(value = """
			SELECT u.* FROM users u\s\
			INNER JOIN abonnement f ON u.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?""", nativeQuery = true)
	List<User> findFollowingByUser(Long idUser);

	Page<User> findByNameContainingOrSurnameContainingOrUsernameContaining(String name, String surname, String username, Pageable pageable);

	@Query(value = "SELECT * FROM users WHERE deletion_date IS NOT NULL "
			+ "AND DATEDIFF(current_timestamp(), deletion_date) >= 14", nativeQuery = true)
	List<User> findByDeletionDateIsNotNull();
}
