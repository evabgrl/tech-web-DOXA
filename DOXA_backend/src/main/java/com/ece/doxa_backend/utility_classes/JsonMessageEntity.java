package com.ece.doxa_backend.utility_classes;

import java.util.Date;

public class JsonMessageEntity {
	private Long messageId;
	private String messageText;
	private Date messageDate;

	public Long getMessageId() {
		return messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	public Date getMessageDate() {
		return messageDate;
	}
}
