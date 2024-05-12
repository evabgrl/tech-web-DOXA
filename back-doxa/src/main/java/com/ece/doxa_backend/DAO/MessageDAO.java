package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.DTO.MessageDTO;

@Repository
public interface MessageDAO extends JpaRepository<MessageDTO, Long> {

	@Query(value = """
			SELECT m.* FROM messages m\s\
			WHERE (m.id_user_transmitter = ?1 AND m.id_user_receiver = ?2)\s\
			OR (m.id_user_transmitter = ?2 AND m.id_user_receiver = ?1)\s\
			ORDER BY m.date DESC LIMIT ?3,15""", nativeQuery = true)
	List<MessageDTO> findByUsers(Long idUser1, Long idUser2, Integer page);

	@Query(value = """
			SELECT MIN(m.id_message) FROM messages m\s\
			WHERE (m.id_user_transmitter = ?1 AND m.id_user_receiver = ?2)\s\
			OR (m.id_user_transmitter = ?2 AND m.id_user_receiver = ?1)\s\
			ORDER BY m.date DESC""", nativeQuery = true)
	Long findLastIdMessageFromUsers(Long idUser1, Long idUser2);
}