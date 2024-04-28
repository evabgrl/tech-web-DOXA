import { Component, Input, OnInit } from '@angular/core';
import { Notification } from 'src/app/models/notification';
import { AuthService } from 'src/app/services/auth.service';
import { NotificationsService } from 'src/app/services/notifications.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
})
export class FooterComponent implements OnInit {
  public areNotificationsEnabled: boolean;
  public notificationsQuantity: number;
  private notifications: Notification[] = [];
  user: User[];

  constructor(
    private notificationsService: NotificationsService,
    public authService: AuthService
  ) {}

  ngOnInit(): void {
    this.areNotificationsEnabled =
      this.notificationsService.getNotificationsStatus();
    if (this.areNotificationsEnabled) {
      this.obtainNotifications();
    }

    //This code detects when the user activates/deactivates notifications.
    this.notificationsService.notificationsEnabledEvent.subscribe(
      (areEnabled) => {
        this.areNotificationsEnabled = areEnabled;
        this.obtainNotifications();
      }
    );

    //This code detects when a user sees one of his notifications, which causes the badge number to be reduced.
    this.notificationsService.notificationViewedOrDeletedEvent.subscribe(
      (notifications) => {
        this.notifications = notifications.filter((n) => !n.isViewed);
        this.notificationsQuantity = this.notifications.length;
      }
    );

    this.notificationsService.newNotificationEvent.subscribe(
      () => this.notificationsQuantity++
    );
  }

  ngOnChanges() {
    this.obtainNotifications();
  }

  private obtainNotifications(): void {
    if (this.areNotificationsEnabled) {
      const user = this.user[0];
      this.notificationsService
        .getNotifications(user)
        .subscribe((notifications) => {
          this.notifications = notifications;
          this.notificationsQuantity = this.notifications.filter(
            (n) => !n.isViewed
          ).length;
        });
    }
  }
}
