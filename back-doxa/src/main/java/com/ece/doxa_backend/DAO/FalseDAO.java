package com.ece.doxa_backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.models.False;

@Repository
public interface FalseDAO extends JpaRepository<False, Long> {

	@Query(value = "SELECT * FROM False l WHERE l.id_post = ?1 && l.id_user = ?2", nativeQuery = true)
	False findByPostAndUser(Long idPost, Long idUser);
}