import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Notification } from 'src/app/models/notification';
import { AuthService } from 'src/app/services/auth.service';
import { NotificationsService } from 'src/app/services/notifications.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-notif',
  templateUrl: './notif.component.html',
  styleUrls: ['./notif.component.css'],
})
export class NotifComponent implements OnInit {
  public areNotificationsEnabled: boolean;
  public notifications: Notification[] = [];

  constructor(
    private notificationsService: NotificationsService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.areNotificationsEnabled =
      this.notificationsService.getNotificationsStatus();

    this.notificationsService.notificationsEnabledEvent.subscribe(
      (areNotificationsEnabled) =>
        (this.areNotificationsEnabled = areNotificationsEnabled)
    );

    this.notificationsService.newNotificationEvent.subscribe(() => {
      if (this.router.url.includes('notif')) {
        Swal.fire({
          position: 'bottom-end',
          timer: 1500,
          background: '#7f5af0',
          timerProgressBar: true,
          showConfirmButton: false,
          color: 'white',
          toast: true,
          icon: 'info',
          didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
          },
        });
      }
    });
  }

  public getOpacity(notification: Notification) {
    return notification.isViewed ? '50%' : '100%';
  }

  public deleteNotification(notification: Notification): void {
    this.notificationsService
      .delete(notification.idNotification)
      .subscribe((response) => {
        console.log(response.message);
        this.notifications = this.notifications.filter(
          (n) => n.idNotification !== response.id
        );
        this.notificationsService.notificationViewedOrDeletedEvent.emit(
          this.notifications
        );
      });
  }

  public viewNotification(notification: Notification) {
    this.notificationsService
      .viewNotification(notification.idNotification)
      .subscribe((response) => console.log(response.message));
    if (notification.type != 'friendship_type') {
      this.notificationsService.notificationViewedOrDeletedEvent.emit(
        this.notifications.filter(
          (n) => n.idNotification !== notification.idNotification
        )
      );
    }
    if (notification.type == 'friend_type') {
      this.router.navigate(['/profile', notification.friend.idUser]);
    }
    if (notification.type == 'post_type') {
      this.router.navigate(['/post', notification.post.idPost]);
    }
    if (notification.type == 'comment_type') {
      this.router.navigate(['/comment', notification.comment.idComment]);
    }
    if (notification.type == 'message_type') {
      this.router.navigate([
        '/profile/chat',
        notification.userTransmitter.idUser,
      ]);
    }
    if (notification.type == 'followership_type') {
      this.router.navigate([
        '/profile',
        notification.abonnement.userFollower.idUser,
      ]);
    }
  }

  private showNoNotificationsModal() {
    Swal.fire({
      icon: 'info',
      showConfirmButton: false,
      timer: 1750,
      background: '#7f5af0',
      color: 'white',
    });
  }
}
