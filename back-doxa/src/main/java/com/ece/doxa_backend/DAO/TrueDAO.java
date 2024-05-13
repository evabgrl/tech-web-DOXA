package com.ece.doxa_backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.models.TrueEntity;

@Repository
public interface TrueDAO extends JpaRepository<TrueEntity, Long> {

	@Query(value = "SELECT * FROM True l WHERE l.id_post = ?1 && l.id_user = ?2", nativeQuery = true)
	TrueEntity findByPostAndUser(Long idPost, Long idUser);
}