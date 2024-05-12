package com.ece.doxa_backend.DTO;

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
public class UserDTO {

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
	private List<CommentDTO> comments;

	@OneToMany
	private List<AbonnementDTO> following;

	@OneToMany
	private List<AbonnementDTO> followers;

	@OneToMany
	private List<TrueDTO> likes;

	@OneToMany(mappedBy = "userTransmitter")
	private List<MessageDTO> messagesTransmitted;

	@OneToMany(mappedBy = "userReceiver")
	private List<MessageDTO> messagesReceived;

	@OneToMany
	private List<PostDTO> posts;

	public UserDTO(final Long idUser, final String username, final String photo, final String description, final Date creationDate,
			final Boolean isChecked) {
		id = idUser;
		this.username = username;
		this.photo = photo;
		this.description = description;
		this.creationDate = creationDate;
		this.isChecked = isChecked;
	}
}