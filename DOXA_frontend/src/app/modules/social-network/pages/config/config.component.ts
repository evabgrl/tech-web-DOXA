import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { AuthService } from 'src/app/services/auth.service';
import { NotificationsService } from 'src/app/services/notifications.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css'],
})
export class ConfigComponent implements OnInit {
  public inputCheck: boolean;
  public selectedLanguage: string;

  constructor(
    public translate: TranslateService,
    private notificationService: NotificationsService,
    public authService: AuthService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    const notifications = localStorage.getItem('notifications');
    if (notifications == null || notifications == 'on') {
      this.inputCheck = true;
    } else {
      this.inputCheck = false;
    }

    this.selectedLanguage = localStorage.getItem('lang');
    if (
      this.selectedLanguage != null &&
      this.translate.currentLang != this.selectedLanguage
    ) {
    } else if (this.selectedLanguage == null) {
      this.selectedLanguage = 'en';
    }
  }

  changeNotifications() {
    this.inputCheck = !this.inputCheck;
    let notif: string;
    this.inputCheck ? (notif = 'on') : (notif = 'off');
    localStorage.setItem('notifications', notif);
    this.notificationService.notificationsEnabledEvent.emit(this.inputCheck);
  }

  startDeletionProcess() {
    Swal.fire({
      background: '#7f5af0',
      color: 'white',
      confirmButtonColor: '#d33',
      showCancelButton: true,
      cancelButtonColor: '#2cb67d',
    });
  }
}
