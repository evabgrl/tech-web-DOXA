package com.ece.doxa_backend.model.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.ece.doxa_backend.model.entity.notification.NotificationAbonnement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Abonnement")
@NoArgsConstructor
public class Abonnement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_followership")
	private Long idFollowership;

	// utilisateur qui est suivi
	@ManyToOne
	@JoinColumn(name = "id_user_checked", nullable = false)
	private User userChecked;

	// utilisateur qui suit
	@ManyToOne
	@JoinColumn(name = "id_user_follower", nullable = false)
	private User userFollower;

	@OneToMany
	private List<NotificationAbonnement> notifications;

	// Constructeur avec deux utilisateurs (suivi et suiveur)
	public Abonnement(final User userChecked, final User userFollower) {
		this.userChecked = userChecked;
		this.userFollower = userFollower;
	}
}
