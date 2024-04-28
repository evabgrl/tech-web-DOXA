package com.ece.doxa_backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.model.entity.True;

@Repository
public interface TrueRepository extends JpaRepository<True, Long> {

	@Query(value = "SELECT * FROM trues l WHERE l.id_post = ?1 && l.id_user = ?2", nativeQuery = true)
	True findByPostAndUser(Long idPost, Long idUser);
}