import { HttpClient } from "@angular/common/http"
import { Injectable } from "@angular/core"
import { catchError, Observable, throwError } from "rxjs"
import { Abonnement } from "../models/abonnement"
import { User } from "../models/user"
import { AuthService } from "./auth.service"
import { CatchErrorService } from "./catch-error.service"

@Injectable({
  providedIn: "root",
})
export class AbonnementService {
  private baseUrl: string = "http://localhost:8090/api/Abonnement"

  constructor(
    private http: HttpClient,
    private authService: AuthService,
    private catchErrorService: CatchErrorService,
  ) {}

  public getAbonnement(idReceiver: number): Observable<Abonnement> {
    return this.http.get<Abonnement>(`${this.baseUrl}/get/${idReceiver}&${this.authService.getUsername()}`).pipe(
      catchError((e) => {
        this.catchErrorService.showErrorModal(e)
        return throwError(() => e)
      }),
    )
  }

  public followUser(userChecked: User): Observable<any> {
    let formData = new FormData()
    formData.append("idUserChecked", userChecked.idUser.toString())
    formData.append("username", this.authService.getUsername())
    return this.http.post<any>(`${this.baseUrl}/post`, formData).pipe(
      catchError((e) => {
        this.catchErrorService.showErrorModal(e)
        return throwError(() => e)
      }),
    )
  }

  public unfollowUser(idFollowership: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/delete/${idFollowership}`).pipe(
      catchError((e) => {
        this.catchErrorService.showErrorModal(e)
        return throwError(() => e)
      }),
    )
  }

  public getFollowersQuantity(idUser: number): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/get/followers-count/${idUser}`).pipe(
      catchError((e) => {
        this.catchErrorService.showErrorModal(e)
        return throwError(() => e)
      }),
    )
  }

  public getFollowingQuantity(idUser: number): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/get/following-count/${idUser}`).pipe(
      catchError((e) => {
        this.catchErrorService.showErrorModal(e)
        return throwError(() => e)
      }),
    )
  }
}
