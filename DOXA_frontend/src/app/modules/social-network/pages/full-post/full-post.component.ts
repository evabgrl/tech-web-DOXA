import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { Comment } from 'src/app/models/comment';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { CommentService } from 'src/app/services/comment.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-full-post',
  templateUrl: './full-post.component.html',
  styleUrls: ['./full-post.component.css'],
})
export class FullPostComponent implements OnInit {
  public post: Post;
  public user: User;
  public comments: Comment[] = [];
  public createdComment: Comment = {
    idComment: 0,
    text: '',
    user: null,
    post: null,
    date: new Date(),
  };
  public commentPlaceholder: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private postService: PostService,
    private authService: AuthService,
    private router: Router,
    private commentService: CommentService,
    private translate: TranslateService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      let id = params['id'];
      if (id) {
        this.postService.getPostById(id).subscribe((post) => {
          this.post = post;
          this.commentService
            .getCommentsByPostId(post.idPost)
            .subscribe((comments) => {
              this.comments = comments;
              this.translateCreateCommentPlaceholder();
            });
        });
      } else {
        this.router.navigate(['/index']);
      }
    });
  }

  public userIsWriting(event) {
    if (event.key === 'Enter' || event.keyCode == 13) {
      this.createComment();
    }
  }

  public createComment() {
    if (
      this.createdComment.text?.length >= 1 &&
      this.createdComment.text?.length <= 100
    ) {
      this.createdComment.user = this.user;
      this.createdComment.post = this.post;
      this.commentService
        .createComment(this.createdComment)
        .subscribe((response) => {
          this.createdComment.date = new Date();
          this.createdComment.idComment = response.idComment;
          this.comments.unshift(this.createdComment);
          // this.createdComment = new Comment('');
        });
    }
  }

  private translateCreateCommentPlaceholder() {
    this.translate
      .get('FULL_POST.CREATE_COMMENT_PLACEHOLDER')
      .subscribe((res: string) => (this.commentPlaceholder = res));
  }
}
