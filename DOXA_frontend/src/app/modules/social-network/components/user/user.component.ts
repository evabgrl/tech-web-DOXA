import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Abonnement } from 'src/app/models/abonnement';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { AbonnementService } from 'src/app/services/abonnement.service';

@Component({
  selector: 'user-comp',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  @Input() public user: User;
  public abonnement: Abonnement;

  constructor(
    public authService: AuthService,
    private router: Router,
    private abonnementService: AbonnementService
  ) {}

  ngOnInit(): void {
    if (this.user.isChecked) {
      this.abonnementService
        .getAbonnement(this.user.idUser)
        .subscribe((abonnement) => {
          this.abonnement = abonnement;
        });
    }
  }

  public goToUser() {
    if (this.user.username == this.authService.getUsername()) {
      this.router.navigate(['/profile']);
    } else {
      this.router.navigate(['/profile', this.user.idUser]);
    }
  }

  public followUser(): void {
    this.abonnementService.followUser(this.user).subscribe((abonnement) => {
      this.abonnement = abonnement;
    });
  }

  public unfollowUser() {
    this.abonnementService
      .unfollowUser(this.abonnement.idFollowership)
      .subscribe((response) => {
        console.log(response.message);
        this.abonnement = null;
      });
  }
}
