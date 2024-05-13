package com.ece.doxa_backend.DTO;

import java.util.Date;
import java.util.List;

public class Post {
	private Long idPost;
	private String text;
	private Date date;
	private User user;
	private boolean reaction;
	private List<Comment> comments;
	private boolean isTrue;

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(final Long idPost) {
		this.idPost = idPost;
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public boolean isReaction() {
		return reaction;
	}

	public void setReaction(final boolean reaction) {
		this.reaction = reaction;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(final List<Comment> comments) {
		this.comments = comments;
	}

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(final boolean aTrue) {
		isTrue = aTrue;
	}
}
