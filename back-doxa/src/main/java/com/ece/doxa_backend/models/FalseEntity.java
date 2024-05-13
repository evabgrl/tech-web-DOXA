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
@Table(name = "FalseDoxa")
public class FalseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_false")
	private Long idFalse;

	// L'annecdote associé
	@ManyToOne
	@JoinColumn(name = "id_post", nullable = false)
	private PostEntity post;

	// L'utilisateur qui a cliqué sur FALSE
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private UserEntity user;

	@Column(name = "date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

}
