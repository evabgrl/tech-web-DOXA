package com.ece.doxa_backend.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.doxa_backend.model.entity.User;
import com.ece.doxa_backend.model.entity.notification.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByUserReceiver(User userReceiver);

	@Modifying
	@Query(value = "DELETE FROM notifications n WHERE n.id_user_receiver = ? AND " + "n.notification_type != 'friend_notif'", nativeQuery = true)
	void deleteAllByUser(Long id);
}
