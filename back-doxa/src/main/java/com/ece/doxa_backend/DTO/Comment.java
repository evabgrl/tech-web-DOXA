package com.ece.doxa_backend.DTO;

import java.util.Date;

public class Comment {
	private Long idComment;
	private String text;
	private User user;
	private Post post;
	private Date date;

	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(final Long idComment) {
		this.idComment = idComment;
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(final Post post) {
		this.post = post;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}
}
