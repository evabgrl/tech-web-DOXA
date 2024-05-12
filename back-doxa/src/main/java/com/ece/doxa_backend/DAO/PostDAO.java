package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.DTO.PostDTO;

@Repository
public interface PostDAO extends JpaRepository<PostDTO, Long> {

//    //region Friends feed
//    @Query(value = "SELECT p.* FROM posts p " +
//            "INNER JOIN friendships f ON p.id_user = f.id_user_transmitter OR " +
//            "p.id_user = f.id_user_receiver " +
//            "WHERE (f.id_user_transmitter = ?1 OR f.id_user_receiver = ?1) " +
//            "AND p.id_user != ?1 " +
//            "AND DATE(p.date) = CURDATE() " +
//            "AND f.status = 1 " +
//            "ORDER BY p.date DESC, p.id_post DESC LIMIT ?2,10",
//            nativeQuery = true)
//    List<Post> findFriendsFeedByUser(Long idUser, Integer from);
//
//    @Query(value = "SELECT MIN(p.id_post) FROM posts p " +
//            "INNER JOIN friendships f ON p.id_user = f.id_user_transmitter OR " +
//            "p.id_user = f.id_user_receiver " +
//            "WHERE (f.id_user_transmitter = ?1 OR f.id_user_receiver = ?1) " +
//            "AND p.id_user != ?1 " +
//            "AND f.status = 1 " +
//            "AND DATE(p.date) = CURDATE()",
//            nativeQuery = true)
//    Long findLastIdPostFromFriendsFeedByUser(Long idUser);
//
//    @Query(value = "SELECT p.* FROM posts p " +
//            "INNER JOIN friendships f ON p.id_user = f.id_user_transmitter OR " +
//            "p.id_user = f.id_user_receiver " +
//            "WHERE (f.id_user_transmitter = ?1 OR f.id_user_receiver = ?1) " +
//            "AND p.id_user != ?1 " +
//            "AND DATE(p.date) != CURDATE() " +
//            "AND f.status = 1 " +
//            "ORDER BY p.date DESC, p.id_post DESC LIMIT ?2,10",
//            nativeQuery = true)
//    List<Post> findOldFriendsFeedByUser(Long idUser, Integer from);
//
//    @Query(value = "SELECT MIN(p.id_post) FROM posts p " +
//            "INNER JOIN friendships f ON p.id_user = f.id_user_transmitter OR " +
//            "p.id_user = f.id_user_receiver " +
//            "WHERE (f.id_user_transmitter = ?1 OR f.id_user_receiver = ?1) " +
//            "AND p.id_user != ?1 " +
//            "AND f.status = 1 " +
//            "AND DATE(p.date) != CURDATE()",
//            nativeQuery = true)
//    Long findLastIdPostFromOldFriendsFeedByUser(Long idUser);
//    //endregion

	@Query(value = """
			SELECT p.* FROM posts p\s\
			INNER JOIN followerships f ON p.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?1\s\
			AND DATE(p.date) = CURDATE()\s\
			ORDER BY p.date DESC, p.id_post DESC LIMIT ?2,10""", nativeQuery = true)
	List<PostDTO> findFollowingFeedByUser(Long idUser, Integer from);

	@Query(value = """
			SELECT MIN(p.id_post) FROM posts p\s\
			INNER JOIN followerships f ON p.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?\s\
			AND DATE(p.date) = CURDATE()""", nativeQuery = true)
	Long findLastIdPostFromFollowingFeedByUser(Long idUser);

	@Query(value = """
			SELECT p.* FROM posts p\s\
			INNER JOIN followerships f ON p.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?1\s\
			AND DATE(p.date) != CURDATE()\s\
			ORDER BY p.date DESC, p.id_post DESC LIMIT ?2,10""", nativeQuery = true)
	List<PostDTO> findOldFollowingFeedByUser(Long idUser, Integer from);

	@Query(value = """
			SELECT MIN(p.id_post) FROM posts p\s\
			INNER JOIN followerships f ON p.id_user = f.id_user_checked\s\
			WHERE f.id_user_follower = ?\s\
			AND DATE(p.date) != CURDATE()""", nativeQuery = true)
	Long findLastIdPostFromOldFollowingFeedByUser(Long idUser);

	@Query(value = """
			SELECT p.*, COUNT(l.id_like) AS total_likes FROM posts p\s\
			INNER JOIN users u ON p.id_user = u.id_user\s\
			INNER JOIN likes l ON p.id_post = l.id_post\s\
			WHERE u.is_checked = 1\s\
			AND p.id_post != 1\s\
			AND DATE(p.date) = CURDATE()\s\
			GROUP BY (p.id_post)\s\
			ORDER BY total_likes DESC, p.date DESC\s\
			LIMIT ?,10""", nativeQuery = true)
	List<PostDTO> findTrendFeed(Integer from);

	@Query(value = """
			SELECT MIN(p.id_post), COUNT(l.id_like) AS total_likes FROM posts p\s\
			INNER JOIN users u ON p.id_user = u.id_user\s\
			INNER JOIN likes l ON p.id_post = l.id_post\s\
			WHERE u.is_checked = 1\s\
			AND p.id_post != 1\s\
			AND DATE(p.date) = CURDATE()\
			GROUP BY (p.id_post)\s\
			ORDER BY total_likes ASC, p.date ASC\s\
			LIMIT 1""", nativeQuery = true)
	Long findLastIdPostFromTrendFeed(Long idUser);

	@Query(value = "SELECT p.* FROM posts p WHERE p.id_user = ?1 AND p.is_pinned = 0 ORDER BY p.date DESC, p.id_post DESC LIMIT ?2,10", nativeQuery = true)
	List<PostDTO> findPostsByUser(Long idUser, Integer from);

	@Query(value = "SELECT MIN(p.id_post) FROM posts p WHERE p.id_user = ? AND p.is_pinned = 0", nativeQuery = true)
	Long findLastIdPostFromPostsByUser(Long idUser);

	@Query(value = """
			SELECT p.* FROM posts p\s\
			INNER JOIN likes l ON p.id_post = l.id_post\s\
			WHERE l.id_user = ?1\s\
			ORDER BY l.date DESC\s\
			LIMIT ?2,10""", nativeQuery = true)
	List<PostDTO> findLikedPostsByUser(Long idUser, Integer from);

	@Query(value = """
			SELECT p.id_post FROM posts p\s\
			INNER JOIN likes l ON p.id_post = l.id_post\s\
			WHERE l.id_user = ? LIMIT 1""", nativeQuery = true)
	Long findLastIdPostFromLikedPostsByUser(Long idUser);

	@Query(value = "SELECT COUNT(*) FROM posts p WHERE p.id_user = ?", nativeQuery = true)
	Integer countPostsByUser(Long idUser);

	@Query(value = """
			SELECT p.*, COUNT(l.id_like) AS total_likes FROM posts p\s\
			INNER JOIN users u ON p.id_user = u.id_user\s\
			INNER JOIN likes l ON p.id_post = l.id_post\s\
			WHERE u.is_checked = 1\s\
			AND DATE(p.date) = CURDATE()\s\
			GROUP BY (p.id_post)\s\
			ORDER BY total_likes DESC, p.date DESC LIMIT 1""", nativeQuery = true)
	PostDTO findTheMostPopularPostFromToday();

	// Méthode pour rechercher un post par son texte
	List<PostDTO> findByTextContaining(String searchText);

}