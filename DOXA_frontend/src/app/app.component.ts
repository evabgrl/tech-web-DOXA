import { Component, HostListener, OnInit } from '@angular/core';
import { ThemePalette } from '@angular/material/core';
import { NavigationEnd, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { filter } from 'rxjs';
import { User } from './models/user';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  constructor(
    private translate: TranslateService,
    public authService: AuthService,
    private router: Router
  ) {
    translate.addLangs(['en', 'es', 'pt']);
  }

  ngOnInit(): void {
    this.login('username', 'password');
    this.getAndSetLanguage();
    this.subscribeToRoutes();
  }

  private login(username: string, password: string) {
    this.authService.login(username, password).subscribe((response) => {
      console.log(response.message);
      if (response?.status && response.status == 201) {
        this.router.navigate(['/profile/edit']);
      }
    });
  }

  private getAndSetLanguage() {
    const lang = localStorage.getItem('lang');
    if (lang) {
      this.translate.use(lang);
    } else {
      this.translate.use('en');
      localStorage.setItem('lang', 'en');
    }
  }

  private subscribeToRoutes() {
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe((event) => {
        event['url'].includes('admin')
          ? (this.authService.userIsOnAdminModule = true)
          : (this.authService.userIsOnAdminModule = false);
      });
  }
}
