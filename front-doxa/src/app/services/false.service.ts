import { HttpClient } from "@angular/common/http"
import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { False } from "../models/false"

@Injectable({
  providedIn: "root",
})
export class FalseService {
  private baseUrl: string = "http://localhost:8090/api/False/"

  constructor(private http: HttpClient) {}

  getAllFalses(): Observable<False[]> {
    return this.http.get<False[]>(this.baseUrl)
  }

  getFalseById(id: number): Observable<False> {
    return this.http.get<False>(`${this.baseUrl}/${id}`)
  }

  getFalsesByPostId(postId: number): Observable<False[]> {
    return this.http.get<False[]>(`${this.baseUrl}/Post/${postId}`)
  }
}
