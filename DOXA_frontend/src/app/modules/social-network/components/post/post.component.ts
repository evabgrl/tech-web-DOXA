import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/models/post';
import { AuthService } from 'src/app/services/auth.service';
import { PostService } from 'src/app/services/post.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'post-comp',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
})
export class PostComponent implements OnInit {
  @Input() public post: Post;
  public isTrueReaction: boolean;
  public isFalseReaction: boolean;

  constructor(
    public authService: AuthService,
    private postService: PostService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.checkUserReactions();
  }

  checkUserReactions() {
    this.postService
      .checkUserResponse(this.post.idPost, true)
      .subscribe((response) => {
        this.isTrueReaction = response === 'true';
      });

    this.postService
      .checkUserResponse(this.post.idPost, false)
      .subscribe((response) => {
        this.isFalseReaction = response === 'true';
      });
  }

  reactToPost(reaction: boolean) {
    this.postService.reactToPost(this.post.idPost, reaction).subscribe(() => {
      this.checkUserReactions();
    });
  }

  deletePost() {
    Swal.fire({
      icon: 'warning',
      showCancelButton: true,
      background: '#7f5af0',
      color: 'white',
      confirmButtonColor: '#d33',
      cancelButtonColor: '#2cb67d',
    }).then((result) => {
      if (result.isConfirmed) {
        this.postService.deletePost(this.post.idPost).subscribe(() => {
          // Rediriger ou mettre à jour l'affichage après la suppression du post
        });
      }
    });
  }

  goToProfile() {
    this.router.navigate(['/profile']);
  }
}
