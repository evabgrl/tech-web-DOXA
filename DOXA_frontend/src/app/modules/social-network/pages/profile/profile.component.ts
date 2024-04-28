import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { filter, Subscription } from 'rxjs';
import { Abonnement } from 'src/app/models/abonnement';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { AbonnementService } from 'src/app/services/abonnement.service';
import { PostService } from 'src/app/services/post.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: [
    './profile.component.css',
    '../../../../../assets/index_profile.css',
  ],
})
export class ProfileComponent implements OnInit {
  public user: User;
  private id: number;
  public abonnement: Abonnement;
  public friendsQuantity: number;
  public userPostQuantity: number;
  public followersQuantity: number;
  public followingQuantity: number;
  public usersYouMayKnow: User[] = [];
  private subscriber: Subscription;
  public pinnedPost: Post;
  public daysUntilElimination: number;
  public daysUntilEliminationParam: any;

  constructor(
    private userService: UserService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private postService: PostService,
    private abonnementService: AbonnementService,
    public authService: AuthService
  ) {}

  ngOnInit(): void {
    this.userService.changePhotoOrDescriptionEvent.subscribe((data) => {
      if (data?.photo) {
        this.user.photo = data.photo;
      }
      if (data?.description) {
        this.user.description = data.description;
      }
    });

    this.subscriber = this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe(() => {
        this.user = null;
        this.abonnement = null;
      });
  }

  private getProfileHeaderData() {
    this.getPostQuantity();
    this.getFollowingQuantity();
    if (this.user.isChecked) {
      this.getFollowersQuantity();
    }
  }

  private getPostQuantity() {
    this.postService
      .countPostByUser(this.user.idUser)
      .subscribe((count) => (this.userPostQuantity = count));
  }

  private getFollowingQuantity() {
    this.abonnementService
      .getFollowingQuantity(this.user.idUser)
      .subscribe(
        (followingQuantity) => (this.followingQuantity = followingQuantity)
      );
  }

  public goToProfile(userYouMayKnow: User) {
    this.router.navigate(['/profile', userYouMayKnow.idUser]);
  }

  public goToFriendsPage(): void {
    if (this.user.idUser) {
      this.router.navigate(['profile/lists/friends', this.user.idUser]);
    }
  }
  //#endregion

  //#region Followership
  private getFollowership() {
    this.abonnementService.getAbonnement(this.id).subscribe((followership) => {
      this.abonnement = followership;
      this.getFollowershipProfileHeaderData();
    });
  }

  private getFollowershipProfileHeaderData() {
    this.getPostQuantity();
    this.getFollowersQuantity();
    this.getFollowingQuantity();
  }

  private getFollowersQuantity() {
    this.abonnementService
      .getFollowersQuantity(this.user.idUser)
      .subscribe(
        (followersQuantity) => (this.followersQuantity = followersQuantity)
      );
  }

  public followUser() {
    this.abonnementService.followUser(this.user).subscribe((followership) => {
      this.abonnement = followership;
      this.followersQuantity++;
    });
  }

  public unfollowUser() {
    this.abonnementService
      .unfollowUser(this.abonnement.idFollowership)
      .subscribe((response) => {
        console.log(response.message);
        this.abonnement = null;
        this.followersQuantity--;
      });
  }

  public goToFollowersPage(): void {
    if (this.user.idUser) {
      this.router.navigate(['profile/lists/followers', this.user.idUser]);
    }
  }

  public goToFollowingPage(): void {
    if (this.user.idUser) {
      this.router.navigate(['profile/lists/following', this.user.idUser]);
    }
  }
  //#endregion

  public moveToPosts(el: HTMLElement) {
    el.scrollIntoView({ behavior: 'smooth' });
  }
}
