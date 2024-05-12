import { Component, OnInit } from "@angular/core"
import { Message } from "../models/message"
import { MessageService } from "../services/message.service"

@Component({
  selector: "app-message",
  templateUrl: "./message.html",
  styleUrls: ["./message.scss"],
})
export class MessageComponent implements OnInit {
  messages: Message[] = []
  newMessage: Message = {
    idMessage: 0,
    text: "",
    userTransmitter: {
      idUser: 0,
      username: "",
      photo: "",
      description: "",
      creationDate: new Date(),
      isChecked: false,
      notifications: [],
      comments: [],
      following: [],
      followers: [],
      likes: [],
      messagesTransmitted: [],
      messagesReceived: [],
      posts: [],
    },
    userReceiver: {
      idUser: 0,
      username: "",
      photo: "",
      description: "",
      creationDate: new Date(),
      isChecked: false,
      notifications: [],
      comments: [],
      following: [],
      followers: [],
      likes: [],
      messagesTransmitted: [],
      messagesReceived: [],
      posts: [],
    },

    date: new Date(),
  }

  constructor(private messageService: MessageService) {}

  ngOnInit(): void {
    this.loadMessages()
  }

  loadMessages(): void {
    // Load messages using MessageService
    this.messageService.getAllMessages().subscribe((messages) => {
      this.messages = messages
    })
  }

  sendMessage(): void {
    // Send message using MessageService
    this.messageService.sendMessage(this.newMessage).subscribe(() => {
      this.loadMessages() // Reload messages after sending
      this.newMessage.text = "" // Clear message input
    })
  }
}
