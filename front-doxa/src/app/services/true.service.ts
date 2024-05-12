import { HttpClient } from "@angular/common/http"
import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { True } from "../models/true"

@Injectable({
  providedIn: "root",
})
export class TrueService {
  private baseUrl: string = "http://localhost:8090/api/True/"

  constructor(private http: HttpClient) {}

  getAllTrues(): Observable<True[]> {
    return this.http.get<True[]>(this.baseUrl)
  }

  getTrueById(id: number): Observable<True> {
    return this.http.get<True>(`${this.baseUrl}/${id}`)
  }

  getTruesByPostId(postId: number): Observable<True[]> {
    return this.http.get<True[]>(`${this.baseUrl}/Post/${postId}`)
  }
}
