import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Student } from "../models/student.model"
import { ActivatedRoute, Router } from "@angular/router"
import { StudentService } from "../services/student.service"

@Component({
  selector: "epf-students",
  templateUrl: "./students.component.html",
  styleUrls: ["./students.component.scss"],
})
export class StudentsComponent {
  students$: Observable<Student[]> = this._route.data.pipe(map((data) => data["students"]))
  constructor(private _route: ActivatedRoute, private studentService: StudentService) {}

  deleteStudent(student: Student) {
    this.studentService.delete(student)
  }

  searchByMajorAndCourse($event: Observable<Student[]>) {
    this.students$ = $event;
  }
}
