package com.ece.doxa_backend.DTO;

public class Abonnement {
	private Long idFollowership;
	private User userChecked;
	private User userFollower;

	public Long getIdFollowership() {
		return idFollowership;
	}

	public void setIdFollowership(final Long idFollowership) {
		this.idFollowership = idFollowership;
	}

	public User getUserChecked() {
		return userChecked;
	}

	public void setUserChecked(final User userChecked) {
		this.userChecked = userChecked;
	}

	public User getUserFollower() {
		return userFollower;
	}

	public void setUserFollower(final User userFollower) {
		this.userFollower = userFollower;
	}
}
