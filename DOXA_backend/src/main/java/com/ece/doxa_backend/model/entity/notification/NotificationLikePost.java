package com.ece.doxa_backend.model.entity.notification;

import com.ece.doxa_backend.model.entity.Post;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("like_post_type")
public class NotificationLikePost extends Notification {

	@ManyToOne
	@JoinColumn(name = "id_post")
	private Post post;

	// ici on récupère le type "like_post_type" pour préciser la notification reçu
	@Override
	public String getType() {
		return "like_post_type";
	}
}
