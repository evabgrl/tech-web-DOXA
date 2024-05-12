import { Injectable } from "@angular/core"
import { HttpClient } from "@angular/common/http"
import { Observable } from "rxjs"
import { Message } from "../models/message"

@Injectable({
  providedIn: "root",
})
export class MessageService {
  private baseUrl = "http://localhost:8080/api/Message"

  constructor(private http: HttpClient) {}

  getAllMessages(): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.baseUrl}/list`)
  }

  getMessageById(id: number): Observable<Message> {
    return this.http.get<Message>(`${this.baseUrl}/get?id=${id}`)
  }

  sendMessage(message: Message): Observable<Message> {
    return this.http.post<Message>(`${this.baseUrl}/send`, message)
  }

  createMessage(message: Message): Observable<Message> {
    return this.http.post<Message>(`${this.baseUrl}/create`, message)
  }

  getMessagesByUsers(userId1: number, userId2: number, page: number): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.baseUrl}/user/${userId1}`)
  }
}
