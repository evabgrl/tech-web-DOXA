package com.ece.doxa_backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.models.FalseEntity;

@Repository
public interface FalseDAO extends JpaRepository<FalseEntity, Long> {

	@Query(value = "SELECT * FROM False l WHERE l.id_post = ?1 && l.id_user = ?2", nativeQuery = true)
	FalseEntity findByPostAndUser(Long idPost, Long idUser);
}