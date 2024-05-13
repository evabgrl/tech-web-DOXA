package com.ece.doxa_backend.DTO;

import java.util.Date;

public class Message {
	private Long idMessage;
	private String text;
	private User userTransmitter;
	private User userReceiver;
	private Date date;

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(final Long idMessage) {
		this.idMessage = idMessage;
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public User getUserTransmitter() {
		return userTransmitter;
	}

	public void setUserTransmitter(final User userTransmitter) {
		this.userTransmitter = userTransmitter;
	}

	public User getUserReceiver() {
		return userReceiver;
	}

	public void setUserReceiver(final User userReceiver) {
		this.userReceiver = userReceiver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}
}
