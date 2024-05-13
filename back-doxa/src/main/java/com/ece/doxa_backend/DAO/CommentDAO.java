package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.models.Comment;
import com.ece.doxa_backend.models.Post;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Post> {
	List<Comment> findAllByPost(Post post);
}
