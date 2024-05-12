package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.DTO.CommentDTO;

@Repository
public interface CommentDAO extends JpaRepository<CommentDTO, Long> {

	@Query(value = """
			SELECT c.* FROM comments c\s\
			WHERE c.id_comment NOT IN (SELECT a.id_reply FROM replies a)\s\
			AND c.id_post = ?\s\
			ORDER BY c.date DESC""", nativeQuery = true)
	List<CommentDTO> findAll(Long idPost);
}
