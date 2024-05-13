package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.models.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Long> {

	@Query(value = """
			SELECT p.* FROM Post p\s\
			INNER JOIN Abonnement f ON p.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?1\s\
			AND DATE(p.date) = CURDATE()\s\
			ORDER BY p.date DESC, p.id_post DESC LIMIT ?2,10""", nativeQuery = true)
	List<Post> findFollowingFeedByUser(Long idUser, Integer from);

	@Query(value = """
			SELECT MIN(p.id_post) FROM Post p\s\
			INNER JOIN Abonnement f ON p.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?\s\
			AND DATE(p.date) = CURDATE()""", nativeQuery = true)
	Long findLastIdPostFromFollowingFeedByUser(Long idUser);

	@Query(value = """
			SELECT p.* FROM Post p\s\
			INNER JOIN Abonnement f ON p.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?1\s\
			AND DATE(p.date) != CURDATE()\s\
			ORDER BY p.date DESC, p.id_post DESC LIMIT ?2,10""", nativeQuery = true)
	List<Post> findOldFollowingFeedByUser(Long idUser, Integer from);

	@Query(value = """
			SELECT MIN(p.id_post) FROM Post p\s\
			INNER JOIN Abonnement f ON p.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?\s\
			AND DATE(p.date) != CURDATE()""", nativeQuery = true)
	Long findLastIdPostFromOldFollowingFeedByUser(Long idUser);

	@Query(value = "SELECT p.* FROM Post p WHERE p.id_user = ?1 ORDER BY p.date DESC, p.id_post DESC LIMIT ?2,10", nativeQuery = true)
	List<Post> findPostsByUser(Long idUser, Integer from);

	@Query(value = "SELECT MIN(p.id_post) FROM Post p WHERE p.id_user = ?", nativeQuery = true)
	Long findLastIdPostFromPostsByUser(Long idUser);

	@Query(value = "SELECT COUNT(*) FROM Post p WHERE p.id_user = ?", nativeQuery = true)
	Integer countPostsByUser(Long idUser);

	// Méthode pour rechercher un post par son texte
	List<Post> findByTextContaining(String searchText);

}