import { Component, EventEmitter, OnInit, Output } from "@angular/core"
import { Observable } from "rxjs"
import { MajorsAndCoursesDto } from "../../models/dto/majorsAndCoursesDto"
import { Major } from "../../models/major.model"
import { MajorService } from "../../services/major.service"
import { Course } from "../../models/course.model"
import { StudentService } from "../../services/student.service"
import { Student } from "../../models/student.model"

@Component({
  selector: "epf-research",
  templateUrl: "./research.component.html",
  styleUrls: ["./research.component.scss"],
})
export class ResearchComponent implements OnInit {
  majorsAndCourses$: Observable<MajorsAndCoursesDto> | undefined
  majorModel: Major | null = null
  courseModel: Course | null = null
  @Output() searchEvent = new EventEmitter<Observable<Student[]>>()

  constructor(private majorService: MajorService, private studentService: StudentService) {
  }

  ngOnInit(): void {
    this.majorsAndCourses$ = this.majorService.findAllMajorsAndAllCourses()
  }

  search() {
    this.searchEvent.emit(this.studentService.searchByMajorAndCourse(new MajorsAndCoursesDto([this.majorModel!!], [this.courseModel!!])))
  }
}
