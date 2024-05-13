import { Injectable } from "@angular/core"
import { HttpClient } from "@angular/common/http"
import { Observable } from "rxjs"
import { Comment } from "../models/comment"
import { User } from "models/user"
import { Post } from "models/Post"

@Injectable({
  providedIn: "root",
})
export class CommentService {
  private baseUrl = "http://localhost:8080/Comment"

  constructor(private http: HttpClient) {}

  getAllComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.baseUrl}`)
  }

  getCommentById(id: number): Observable<Comment> {
    return this.http.get<Comment>(`${this.baseUrl}/${id}`)
  }

  createComment(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>(`${this.baseUrl}`, comment)
  }

  deleteComment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`)
  }

  getCommentsByPostId(postId: number): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.baseUrl}/Post/${postId}`)
  }

  addComment(post: Post, user: User, text: string): Observable<Comment> {
    const newComment: Comment = {
      idComment: 0, // Assuming idComment will be set by the server
      post: post,
      user: user,
      text: text,
      date: new Date(), // You may need to adjust the date format as per your server requirements
    }
    return this.createComment(newComment)
  }
}
