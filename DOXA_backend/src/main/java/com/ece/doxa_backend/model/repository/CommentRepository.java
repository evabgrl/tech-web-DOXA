package com.ece.doxa_backend.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.model.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query(value = """
			SELECT c.* FROM comments c\s\
			WHERE c.id_comment NOT IN (SELECT a.id_reply FROM replies a)\s\
			AND c.id_post = ?\s\
			ORDER BY c.date DESC""", nativeQuery = true)
	List<Comment> findAll(Long idPost);
}
