package com.ece.doxa_backend.models;

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
public class MessageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_message")
	private Long idMessage;

	@Column(name = "text", nullable = false)
	private String text;

	@ManyToOne
	@JoinColumn(name = "user_transmitter_id", nullable = false)
	private UserEntity userTransmitter;

	@ManyToOne
	@JoinColumn(name = "user_receiver_id", nullable = false)
	private UserEntity userReceiver;

	@Column(name = "date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

}
