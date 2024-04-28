package com.ece.doxa_backend.model.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.ece.doxa_backend.model.entity.notification.Notification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long idUser;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "photo")
	private String photo;

	@Column(name = "description")
	private String description;

	@Column(name = "creation_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "is_checked", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean isChecked;

	@OneToMany
	private List<Notification> notifications;

	@OneToMany
	private List<Comment> comments;

	@OneToMany
	private List<Abonnement> following;

	@OneToMany
	private List<Abonnement> followers;

	@OneToMany
	private List<True> likes;

	@OneToMany
	private List<Message> messagesTransmitted;

	@OneToMany
	private List<Message> messagesReceived;

	@OneToMany
	private List<Post> posts;

	public User(final Long idUser, final String username, final String photo, final String description, final Date creationDate,
			final Boolean isChecked) {
		this.idUser = idUser;
		this.username = username;
		this.photo = photo;
		this.description = description;
		this.creationDate = creationDate;
		this.isChecked = isChecked;
	}
}