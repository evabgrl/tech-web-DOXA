package com.ece.doxa_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.models.MessageEntity;

@Repository
public interface MessageDAO extends JpaRepository<MessageEntity, Long> {

	List<MessageEntity> findByUserTransmitterIdAndUserReceiverId(Long userTransmitterId, Long userReceiverId);

	@Query(value = """
			SELECT MIN(id_message) FROM Message\s\
			WHERE (id_user_transmitter = :idUser1 AND id_user_receiver = :idUser2)\s\
			OR (id_user_transmitter = :idUser2 AND id_user_receiver = :idUser1)\s\
			ORDER BY date DESC""", nativeQuery = true)
	Long findLastIdMessageFromUsers(@Param("idUser1") Long idUser1, @Param("idUser2") Long idUser2);

}