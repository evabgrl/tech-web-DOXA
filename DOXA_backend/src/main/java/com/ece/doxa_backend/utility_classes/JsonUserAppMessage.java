package com.ece.doxa_backend.utility_classes;

import com.ece.doxa_backend.model.entity.User;

public class JsonUserAppMessage {
	private String message;
	private Integer status;
	private User user;

	public String getMessage() {
		return message;
	}

	public Integer getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}
}
