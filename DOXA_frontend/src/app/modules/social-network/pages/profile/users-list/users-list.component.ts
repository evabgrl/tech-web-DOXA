import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-friends',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css'],
})
export class FriendsComponent implements OnInit {
  public users: User[] = [];
  public page: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private userService: UserService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.page = params['page'];
      let id = params['id'];
      if (this.page && id) {
        this.userService.getAllUsers().subscribe((users) => {
          this.users = users;
        });
      }
    });
  }
}
