package com.ece.doxa_backend.model.entity.notification;

import com.ece.doxa_backend.model.entity.Comment;
import com.ece.doxa_backend.model.entity.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("comment_type")
@NoArgsConstructor
public class NotificationComment extends Notification {

	@ManyToOne
	@JoinColumn(name = "id_comment")
	private Comment comment;

	public NotificationComment(final User userReceiver, final Comment comment) {
		super(userReceiver);
		this.comment = comment;
	}

	// ici on récupère le type "comment_type" pour préciser la notification reçu
	@Override
	public String getType() {
		return "comment_type";
	}
}
