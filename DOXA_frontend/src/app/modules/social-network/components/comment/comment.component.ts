import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Comment } from 'src/app/models/comment';
import { User } from 'src/app/models/user';
import { CommentService } from 'src/app/services/comment.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'comment-comp',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
})
export class CommentComponent implements OnInit {
  @Input() public comment: Comment;
  @Input() public commentLevel: number;
  public user: User[];
  public replies: Comment[];

  constructor(private router: Router, private commentService: CommentService) {}

  ngOnInit(): void {}

  public goToProfile() {
    this.router.navigate(['/profile']);
  }

  public async showReplyModal() {
    const { value: commentText } = await Swal.fire({
      input: 'textarea',
      inputAttributes: { maxlength: '100' },
      showCancelButton: true,
      background: '#7f5af0',
      color: 'white',
      confirmButtonColor: '#2cb67d',
      cancelButtonColor: '#d33',
    });

    if (commentText) {
      this.createComment(commentText);
    }
  }

  private createComment(commentText: string) {
    if (commentText && commentText.length <= 100 && this.comment.post) {
      const user: User = {
        idUser: 1,
        username: 'eabgrall',
        photo: 'path/to/photo.jpg',
        description: "Description de l'utilisateur",
        creationDate: new Date(),
        isChecked: true,
        notifications: [],
        comments: [],
        following: [],
        followers: [],
        likes: [],
        messagesTransmitted: [],
        messagesReceived: [],
        posts: [],
      };

      const comment: Comment = {
        idComment: 0,
        text: commentText,
        user: user,
        post: this.comment.post,
        date: new Date(),
      };

      this.commentService.createComment(comment).subscribe((response) => {
        // Gérer la réponse ici si nécessaire
      });
    }
  }
}
