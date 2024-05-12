package com.ece.doxa_backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.DTO.TrueDTO;

@Repository
public interface TrueDAO extends JpaRepository<TrueDTO, Long> {

	@Query(value = "SELECT * FROM trues l WHERE l.id_post = ?1 && l.id_user = ?2", nativeQuery = true)
	TrueDTO findByPostAndUser(Long idPost, Long idUser);
}