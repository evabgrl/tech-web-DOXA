package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.DTO.CommentDTO;
import com.ece.doxa_backend.DTO.PostDTO;

@Repository
public interface CommentDAO extends JpaRepository<CommentDTO, PostDTO> {
	List<CommentDTO> findAllByPost(PostDTO post);
}
