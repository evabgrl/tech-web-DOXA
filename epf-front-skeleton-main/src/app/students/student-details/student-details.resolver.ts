import { Injectable } from "@angular/core"
import { Router, Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from "@angular/router"
import { first, mergeMap, Observable, of } from "rxjs"
import { StudentService } from "../../services/student.service"
import { Student } from "../../models/student.model"
import { Major } from "../../models/major.model"

@Injectable({
  providedIn: "root",
})
export class StudentDetailsResolver implements Resolve<Student> {
  constructor(private studentService: StudentService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Student> {
    if (route.params["id"] == "new") {
      return new Observable((observer) => observer.next(new Student("", "", new Major("", ""))))
    }
    return this.studentService.findById(parseInt(route.paramMap.get("id")!!, 10))
  }
}
