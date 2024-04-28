import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { PostService } from 'src/app/services/post.service';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-newpost',
  templateUrl: './newpost.component.html',
  styleUrls: ['./newpost.component.css'],
})
export class NewpostComponent implements OnInit {
  files: File[] = [];
  users: User[] = [
    {
      idUser: 1,
      username: 'nom_utilisateur',
      photo: 'chemin_vers_photo',
      description: 'description_utilisateur',
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
    },
  ];

  public placeholder: string;
  public postText: string;
  public publishBtnText: string;

  constructor(
    private translate: TranslateService,
    private postService: PostService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.translate
      .get('NEWPOST.PLACEHOLDER')
      .subscribe((res: string) => (this.placeholder = res));
  }

  onSelect(event) {
    this.files.push(...event.addedFiles);
    if (this.files.length > 1) {
      this.replaceFile();
    }
  }

  onRemove(event) {
    this.files.splice(this.files.indexOf(event), 1);
  }

  replaceFile() {
    this.files.splice(0, 1);
  }

  public createPost() {
    if (this.postText == null && this.files[0] == null) {
      this.fireErrorModal();
    } else {
      this.sendPost();
    }
  }

  private fireErrorModal() {
    Swal.fire({
      icon: 'error',
      showConfirmButton: false,
      timer: 1250,
      background: '#7f5af0',
      color: 'white',
    });
  }

  private sendPost() {
    if (!this.postText) {
      this.postText = '';
    }
    const newPost: Post = {
      idPost: 1,
      text: 'Contenu du post',
      date: new Date(),
      user: this.users[0],
      comments: [],
      notifications: [],
      isTrue: true,
      reactions: [],
    };

    this.postService.createPost(newPost).subscribe((response) => {
      this.postText = '';
      this.files = [];
      this.router.navigate(['post/', response.idPost]);
    });
  }
}
