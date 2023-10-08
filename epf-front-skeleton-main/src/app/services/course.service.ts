import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { Course } from "models/course.model"
import { ConstantsMockService } from "./constantsMock.service"
import { HttpClient } from "@angular/common/http"

@Injectable({
  providedIn: "root",
})
export class CourseService {
  constructor(private constantsMockService: ConstantsMockService, private http: HttpClient) {
  }

  private coursesUrl = "http://localhost:8080/courses"

  // // FIXME : change to api call with httpclient
  // findAll(): Observable<Course[]> {
  //   return new Observable((observer) => observer.next(this.constantsMockService.courses))
  // }

  findAll(): Observable<Course[]> {
    return this.http.get<Course[]>(this.coursesUrl)
  }
}
