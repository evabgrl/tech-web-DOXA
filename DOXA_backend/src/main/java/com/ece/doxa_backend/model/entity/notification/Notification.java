package com.ece.doxa_backend.model.entity.notification;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.ece.doxa_backend.model.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "notifications")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "notification_type")
@NoArgsConstructor
public abstract class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_notification")
	private Long idNotification;

	@ManyToOne
	@JoinColumn(name = "id_user_receiver", nullable = false)
	private User userReceiver;

	@Column(name = "is_viewed", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean isViewed;

	@Column(name = "date", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date date;

	public String getType() {
		return "notification_type"; // cette classe sert de base pour pouvoir différencier les autres types de
									// notification
	}

	public Notification(final User userReceiver) {
		this.userReceiver = userReceiver;
	}
}