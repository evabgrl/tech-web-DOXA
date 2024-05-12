import { HttpClient, HttpHeaders } from "@angular/common/http"
import { Injectable } from "@angular/core"
import { catchError, Observable, throwError } from "rxjs"
import { User } from "../models/user"

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private baseUrl = "http://localhost:8090/api/app/"
  public userIsOnAdminModule: boolean = false

  constructor(private http: HttpClient) {}

  public login(username: string, password: string): Observable<any> {
    const credentials = { username, password }
    const httpHeaders = new HttpHeaders({ "Content-Type": "application/json" })
    return this.http
      .post<any>(this.baseUrl + "login", credentials, { headers: httpHeaders })
      .pipe(catchError((e) => throwError(() => new Error(e))))
  }

  public getUsername(): string {
    let payload = this.obtainPayload("token")
    return payload.preferred_username
  }

  public hasRole(token: string, role: string): boolean {
    let payload = this.obtainPayload(token)

    return payload.resource_access.springback.roles.includes(role)
  }

  private obtainPayload(access_token: string): any {
    return JSON.parse(window.atob(access_token.split(".")[1]))
  }
}
