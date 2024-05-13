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
@Table(name = "True")
public class TrueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_true")
	private Long idTrue;

	// L'annecdote associé
	@ManyToOne
	@JoinColumn(name = "id_post", nullable = false)
	private PostEntity post;

	// L'utilisateur qui a cliqué sur TRUE
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private UserEntity user;

	@Column(name = "date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

}
