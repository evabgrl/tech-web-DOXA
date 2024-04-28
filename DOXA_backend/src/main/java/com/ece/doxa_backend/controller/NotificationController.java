package com.ece.doxa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.doxa_backend.model.entity.User;
import com.ece.doxa_backend.model.entity.notification.Notification;
import com.ece.doxa_backend.model.service.NotificationService;

@RestController
@RequestMapping("api/notifications/")
@PreAuthorize("isAuthenticated()")
public class NotificationController {

	private final NotificationService notificationService;

	@Autowired
	public NotificationController(final NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@GetMapping
	public List<Notification> getAllNotifications() {
		return notificationService.toList();
	}

	@PostMapping
	public Notification createNotification(@RequestBody final Notification notification) {
		return notificationService.save(notification);
	}

	@DeleteMapping("/{id}")
	public void deleteNotification(@PathVariable final Long id) {
		final var notification = notificationService.findById(id);
		if (notification != null) {
			notificationService.delete(notification);
		}
	}

	@GetMapping("/user/{userId}")
	public List<Notification> getNotificationsByUser(@PathVariable final Long userId) {
		final var user = new User(); // Assuming you have a User entity
		user.setIdUser(userId);
		return notificationService.findByUser(user);
	}

	@DeleteMapping("/user/{userId}")
	public void deleteNotificationsByUser(@PathVariable final Long userId) {
		notificationService.deleteAllByUser(userId);
	}
}