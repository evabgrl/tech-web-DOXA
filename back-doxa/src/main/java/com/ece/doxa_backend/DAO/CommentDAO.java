package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.models.CommentEntity;
import com.ece.doxa_backend.models.PostEntity;

@Repository
public interface CommentDAO extends JpaRepository<CommentEntity, PostEntity> {
	List<CommentEntity> findAllByPost(PostEntity post);
}
