import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { Course } from "../models/course.model"
import { ConstantsMockService } from "./constantsMock.service"

@Injectable({
  providedIn: "root",
})
export class CourseService {
  constructor(private constantsMockService: ConstantsMockService) {
  }

  // FIXME : change to api call with httpclient
  findAll(): Observable<Course[]> {
    return new Observable((observer) => observer.next(this.constantsMockService.courses))
  }
}
