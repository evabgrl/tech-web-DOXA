package com.ece.doxa_backend.model.entity.notification;

import com.ece.doxa_backend.model.entity.Abonnement;
import com.ece.doxa_backend.model.entity.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("abonnement_type")
@NoArgsConstructor
public class NotificationAbonnement extends Notification {

	@ManyToOne
	@JoinColumn(name = "id_followership")
	private Abonnement abonnement;

	public NotificationAbonnement(final User userReceiver, final Abonnement abonnement) {
		super(userReceiver);
		this.abonnement = abonnement;
	}

	// ici on récupère le type "abonnement_type" pour préciser la notification reçu
	@Override
	public String getType() {
		return "abonnement_type";
	}
}
