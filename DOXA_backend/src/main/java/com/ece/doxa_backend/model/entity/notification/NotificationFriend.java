package com.ece.doxa_backend.model.entity.notification;

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
@DiscriminatorValue("friend_type")
@NoArgsConstructor
public class NotificationFriend extends Notification {

	@ManyToOne
	@JoinColumn(name = "id_user_friend")
	private User friend;

	public NotificationFriend(final User userReceiver, final User friend) {
		super(userReceiver);
		this.friend = friend;
	}

	// ici on récupère le type "friend_type" pour préciser la notification reçu
	@Override
	public String getType() {
		return "friend_type";
	}
}
