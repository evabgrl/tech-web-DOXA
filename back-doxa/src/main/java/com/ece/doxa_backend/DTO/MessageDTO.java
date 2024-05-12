package com.ece.doxa_backend.DTO;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Message")
public class MessageDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_message")
	private Long idMessage;

	@Column(name = "text", nullable = false)
	private String text;

	// L'utilisateur qui a envoyé le message
	@ManyToOne
	@JoinColumn(name = "id_user_transmitter", nullable = false)
	private UserDTO userTransmitter;

	// L'utilisateur qui a reçu le message
	@ManyToOne
	@JoinColumn(name = "id_user_receiver", nullable = false)
	private UserDTO userReceiver;

	@Column(name = "date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

}
