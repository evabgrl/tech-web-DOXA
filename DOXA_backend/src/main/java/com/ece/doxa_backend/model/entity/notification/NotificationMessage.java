package com.ece.doxa_backend.model.entity.notification;

import com.ece.doxa_backend.model.entity.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("message_type")
public class NotificationMessage extends Notification {

	@ManyToOne
	@JoinColumn(name = "id_user_message_transmitter")
	private User userTransmitter;

	// ici on récupère le type "message_type" pour préciser la notification reçu
	@Override
	public String getType() {
		return "message_type";
	}
}
