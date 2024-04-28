package com.ece.doxa_backend.model.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comment")
	private Long idComment;

	@Column(name = "text", nullable = false)
	private String text;

	// L'utilisateur qui a écrit le commentaire
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	// Le post auquel le commentaire est associé
	@ManyToOne
	@JoinColumn(name = "id_post")
	private Post post;

	@Column(name = "date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

}
