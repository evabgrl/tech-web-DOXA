package com.ece.doxa_backend.models;

import java.util.Date;

public class True {
	private Long idTrue;
	private Post post;
	private User user;
	private Date date;

	public Long getIdTrue() {
		return idTrue;
	}

	public void setIdTrue(final Long idTrue) {
		this.idTrue = idTrue;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(final Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}
}
