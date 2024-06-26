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
@Table(name = "Comment")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comment")
	private Long idComment;

	@Column(name = "text", nullable = false)
	private String text;

	// L'utilisateur qui a écrit le commentaire
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private UserEntity user;

	// Le post auquel le commentaire est associé
	@ManyToOne
	@JoinColumn(name = "id_post")
	private PostEntity post;

	@Column(name = "date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

}
