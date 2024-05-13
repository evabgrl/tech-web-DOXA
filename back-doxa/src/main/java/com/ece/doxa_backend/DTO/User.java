package com.ece.doxa_backend.DTO;

import java.util.Date;
import java.util.List;

public class User {
	private Long id;
	private String username;
	private String photo;
	private String description;
	private Date creationDate;
	private Boolean isChecked;
	private List<Comment> comments;
	private List<Abonnement> following;
	private List<Abonnement> followers;
	private List<True> likes;
	private List<Message> messagesTransmitted;
	private List<Message> messagesReceived;
	private List<Post> posts;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(final String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getChecked() {
		return isChecked;
	}

	public void setChecked(final Boolean checked) {
		isChecked = checked;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(final List<Comment> comments) {
		this.comments = comments;
	}

	public List<Abonnement> getFollowing() {
		return following;
	}

	public void setFollowing(final List<Abonnement> following) {
		this.following = following;
	}

	public List<Abonnement> getFollowers() {
		return followers;
	}

	public void setFollowers(final List<Abonnement> followers) {
		this.followers = followers;
	}

	public List<True> getLikes() {
		return likes;
	}

	public void setLikes(final List<True> likes) {
		this.likes = likes;
	}

	public List<Message> getMessagesTransmitted() {
		return messagesTransmitted;
	}

	public void setMessagesTransmitted(final List<Message> messagesTransmitted) {
		this.messagesTransmitted = messagesTransmitted;
	}

	public List<Message> getMessagesReceived() {
		return messagesReceived;
	}

	public void setMessagesReceived(final List<Message> messagesReceived) {
		this.messagesReceived = messagesReceived;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(final List<Post> posts) {
		this.posts = posts;
	}
}
