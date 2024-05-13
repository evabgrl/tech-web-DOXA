package com.ece.doxa_backend.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

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
	private List<CommentEntity> comments;

	@OneToMany
	private List<AbonnementEntity> following;

	@OneToMany
	private List<AbonnementEntity> followers;

	@OneToMany
	private List<TrueEntity> likes;

	@OneToMany(mappedBy = "userTransmitter")
	private List<MessageEntity> messagesTransmitted;

	@OneToMany(mappedBy = "userReceiver")
	private List<MessageEntity> messagesReceived;

	@OneToMany
	private List<PostEntity> posts;

	public UserEntity(final Long idUser, final String username, final String photo, final String description, final Date creationDate,
			final Boolean isChecked) {
		id = idUser;
		this.username = username;
		this.photo = photo;
		this.description = description;
		this.creationDate = creationDate;
		this.isChecked = isChecked;
	}
}