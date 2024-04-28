package com.ece.doxa_backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.model.entity.False;

@Repository
public interface FalseRepository extends JpaRepository<False, Long> {

	@Query(value = "SELECT * FROM falses l WHERE l.id_post = ?1 && l.id_user = ?2", nativeQuery = true)
	False findByPostAndUser(Long idPost, Long idUser);
}