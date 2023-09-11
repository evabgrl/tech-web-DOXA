import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Student } from "../../models/student.model"
import { ActivatedRoute, Router } from "@angular/router"
import { FormControl } from "@angular/forms"
import { Course } from "../../models/course.model"
import { CourseService } from "../../services/course.service"
import { StudentService } from "../../services/student.service"

@Component({
  selector: "epf-student-details",
  templateUrl: "./student-details.component.html",
  styleUrls: ["./student-details.component.scss"],
})
export class StudentDetailsComponent {
  student$: Observable<Student> = this._route.data.pipe(map((data) => data["student"]))
  allCourses$: Observable<Course[]> | undefined
  courseSelectModel: Course | null = null
  notSelectedCourse: boolean | undefined
  today = new Date(Date.now())
  constructor(
    private _route: ActivatedRoute,
    private courseService: CourseService,
    private studentService: StudentService,
    private router: Router,
  ) {}

  courseClick() {
    this.allCourses$ = this.courseService.findAll()
  }

  addCourseToStudent(student: Student) {
    if (this.courseSelectModel != null) {
      this.studentService.addCourseToStudent(student, this.courseSelectModel!!)
    } else {
      this.notSelectedCourse = true
    }
  }

  removeCourseToStudent(student: Student, course: Course) {
    this.studentService.removeCourseToStudent(student, course)
  }

  save(student: Student) {
    this.studentService.save(student)
    this.router.navigate(["students"])
  }

  // because the format of the date doesn't fit date picker
  updateBirthdate($event: any, student: Student) {
    student.birthDate = new Date($event)
  }
}
