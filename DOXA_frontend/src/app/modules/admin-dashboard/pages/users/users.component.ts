import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent implements OnInit {
  public placeholder: string;
  public name: string;
  public searchName: string;
  public page: number;
  public paginator: any;
  public users: User[] = [];

  constructor(
    private authService: AuthService,
    private userService: UserService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.authService.userIsOnAdminModule = true;

    this.activatedRoute.params.subscribe((params) => {
      if (params['name'] && params['page']) {
        this.name = params['name'];
        this.searchName = params['name'];
        this.page = params['page'];
        this.searchUsers();
      }
    });
  }

  public search(event) {
    if (event.key === 'Enter' || event.keyCode == 13) {
      this.searchUsers();
    }
  }

  public searchUsers() {
    if (this.searchName && this.searchName.length >= 3) {
      if (!this.page || this.searchName != this.name) {
        this.router.navigate(['/admin/users/' + this.searchName + '/0']);
      } else {
        this.getUsers();
      }
    }
  }

  private getUsers() {
    this.userService.getAllUsers();
  }
}
