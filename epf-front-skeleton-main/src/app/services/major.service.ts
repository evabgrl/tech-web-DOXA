import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { Major } from "models/major.model"
import { MajorStudentsDto } from "models/dto/MajorStudentsDto"
import { MajorsAndCoursesDto } from "models/dto/majorsAndCoursesDto"
import { ConstantsMockService } from "./constantsMock.service"
import { HttpClient } from "@angular/common/http"

@Injectable({
  providedIn: "root",
})
export class MajorService {
  constructor(private constantsMockService: ConstantsMockService, private http: HttpClient) {
  }

  private majorUrl = "http://localhost:8080/majors"

  // findAll(): Observable<Major[]> {
  //   return new Observable((observer) => observer.next(this.constantsMockService.majors))
  // }

  findAll(): Observable<Major[]> {
    return this.http.get<Major[]>(this.majorUrl)
  }

  findStudentsFromMajor(majorId: string): Observable<MajorStudentsDto> {
    let major = this.findById(BigInt(majorId))
    return new Observable((observer) =>
      observer.next(new MajorStudentsDto(major!!, this.constantsMockService.students.filter(s => s.major === major))),
    )
  }

  findById(id: bigint) {
    return this.constantsMockService.majors.find((m) => m.id === id)
  }

  findAllMajorsAndAllCourses(): Observable<MajorsAndCoursesDto> {
    return new Observable((observer) => observer.next(new MajorsAndCoursesDto(this.constantsMockService.majors, this.constantsMockService.courses)))
  }

}
