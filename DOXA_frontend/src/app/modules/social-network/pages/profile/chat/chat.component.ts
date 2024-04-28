import {
  AfterViewChecked,
  Component,
  ElementRef,
  OnDestroy,
  OnInit,
  ViewChild,
} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from 'src/app/models/message';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { MessageService } from 'src/app/services/message.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
})
export class ChatComponent implements OnInit, AfterViewChecked {
  public user: User;
  public friend: User;
  public message: Message;
  public file: File;
  public messages: Message[] = [];
  public friendStatus: string;
  @ViewChild('scrollChat') private scrollChat: ElementRef;
  private page: number = 0;
  public isLastPage: boolean;

  private scrollDisabled: boolean = false;

  constructor(
    private authService: AuthService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private messageService: MessageService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      let id = params['id'];

      this.router.navigate(['/index']);
    });
  }

  ngAfterViewChecked(): void {
    this.scrollToBottom();
  }

  private scrollToBottom() {
    if (this.messages.length !== 0 && !this.scrollDisabled) {
      this.scrollChat.nativeElement.scrollTop =
        this.scrollChat.nativeElement.scrollHeight;
      this.scrollDisabled = true;
    }
  }

  private initChat() {
    this.messageService
      .getMessagesByUsers(this.user.idUser, this.friend.idUser, this.page)
      .subscribe((response) => {
        this.messages = response.reverse();
        this.isLastPage = this.isLastPage;
      });
  }
  //#endregion

  public sendMessage() {
    if (this.message?.text || this.file) {
      this.createMessage();
    } else {
      Swal.fire({
        icon: 'error',
        showConfirmButton: false,
        timer: 1250,
        background: '#7f5af0',
        color: 'white',
      });
    }
  }

  private createMessage() {
    if (!this.message?.text) {
      this.message.text = '';
    }
    if (this.message.text?.length <= 50) {
      this.message.userTransmitter = this.user;
      this.message.userReceiver = this.friend;
      this.message.idMessage = 0;
      this.messageService.createMessage(this.message).subscribe((response) => {
        this.message.idMessage = response.idMessage;
        this.message.text = response.text;
        this.message.date = response.date;
        this.messages.push(this.message);
        // this.message = new Message('');
        this.file = null;
        this.scrollDisabled = false;
      });
    }
  }

  public userIsWriting(event) {
    if (event.key === 'Enter' || event.keyCode == 13) {
      this.sendMessage();
    }
  }

  public getMoreMessagesIfTheUserScrollToTop() {
    let fullScrollHeight = this.scrollChat.nativeElement.scrollHeight;
    if (this.scrollChat.nativeElement.scrollTop == 0 && !this.isLastPage) {
      this.getMoreMessages(fullScrollHeight);
    }
  }

  private getMoreMessages(fullScrollHeight: number) {
    this.page += 15;
    this.messageService
      .getMessagesByUsers(this.user.idUser, this.friend.idUser, this.page)
      .subscribe((response) => {
        this.messages = response.reverse().concat(this.messages);
        this.isLastPage = this.isLastPage;
        setTimeout(() => {
          this.scrollChat.nativeElement.scrollTop =
            this.scrollChat.nativeElement.scrollHeight - fullScrollHeight;
        }, 0);
      });
  }

  public selectPhoto(event) {
    this.file = event.target.files[0];
    if (this.file.type.indexOf('image') < 0) {
      Swal.fire({
        icon: 'error',
        showConfirmButton: false,
        timer: 1500,
        background: '#7f5af0',
        color: 'white',
      });
      this.file = null;
    }
  }

  public unselectFile() {
    this.file = null;
  }
}
