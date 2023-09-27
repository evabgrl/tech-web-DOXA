import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { Student } from "models/student.model"
import { Course } from "models/course.model"
import { ConstantsMockService } from "./constantsMock.service"
import { MajorsAndCoursesDto } from "models/dto/majorsAndCoursesDto"
import { HttpClient } from "@angular/common/http"

@Injectable({
  providedIn: "root",
})
export class StudentService {
  constructor(private constantsMockService: ConstantsMockService, private http: HttpClient) {
  }

  private studentsUrl = "http://localhost:8080/students"

  findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsUrl)
  }

  findById(id: number): Observable<Student> {
    return this.http.get<Student>(this.studentsUrl + `/${id}` )
  }

  update(id: number, student: Student): Observable<Student> {
    return this.http.post<Student>(this.studentsUrl + `/${id}`, student)
  }

  create(student: Student): Observable<Student> {
    return this.http.post<Student>(this.studentsUrl, student)
  }

  delete(student: Student) {
    const index = this.constantsMockService.students.indexOf(student)
    if (index > -1) {
      this.constantsMockService.students.splice(index, 1)
    }
  }

  addCourseToStudent(student: Student, course: Course) {
    if (student.courses == undefined) {
      student.courses = [course]
    } else {
      student.courses.push(course)
    }
    return student
  }

  removeCourseToStudent(student: Student, course: Course) {
    const index = student.courses?.indexOf(course)
    if (index!! > -1) {
      student.courses?.splice(index!!, 1)
    }
    return student
  }

  // save(student: Student) {
  //   const index = this.constantsMockService.students.indexOf(student)
  //   if (index > -1) {
  //     this.constantsMockService.students.splice(index, 1, student)
  //   } else {
  //     student.id = BigInt(this.constantsMockService.students.length + 1)
  //     this.constantsMockService.students.push(student)
  //   }
  // }

  searchByMajorAndCourse(majorsAndCoursesDto: MajorsAndCoursesDto): Observable<Student[]> {
    return new Observable((observer) => observer.next(this.constantsMockService.students.filter(s => s.major.id === majorsAndCoursesDto.majors[0].id && s.courses?.includes(majorsAndCoursesDto.courses[0]))))
  }

}
