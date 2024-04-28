import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Post } from '../models/post';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  private baseUrl = 'http://localhost:8080/api/posts';

  constructor(private http: HttpClient) {}

  getAllPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.baseUrl}`);
  }

  getPostById(id: number): Observable<Post> {
    return this.http.get<Post>(`${this.baseUrl}/${id}`);
  }

  createPost(post: Post): Observable<Post> {
    return this.http.post<Post>(`${this.baseUrl}`, post);
  }

  deletePost(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  checkUserResponse(postId: number, userResponse: boolean): Observable<string> {
    return this.http.get<string>(
      `${this.baseUrl}/${postId}/response/${userResponse}`
    );
  }

  public countPostByUser(idUser: number): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/get/count/${idUser}`);
  }

  reactToPost(postId: number, reaction: boolean): Observable<void> {
    return this.http.post<void>(
      `${this.baseUrl}/${postId}/reactions`,
      reaction
    );
  }
}
