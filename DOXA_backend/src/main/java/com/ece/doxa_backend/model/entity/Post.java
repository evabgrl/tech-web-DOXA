package com.ece.doxa_backend.model.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.ece.doxa_backend.model.entity.notification.NotificationLikePost;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_post")
	private Long idPost;

	@Column(name = "text")
	private String text;

	@Column(name = "date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

	// utilisateur qui a créé le post
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	private boolean reaction;

	public boolean getReaction() {
		return reaction;
	}

	public void setReaction(final boolean reaction) {
		this.reaction = reaction;
	}

	// liste des commentaires associés
	@OneToMany
	private List<Comment> comments;

	@OneToMany
	private List<NotificationLikePost> notifications;

	@Column(name = "is_true", nullable = false, columnDefinition = "BOOLEAN")
	private boolean isTrue;

}
