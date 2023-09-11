import { Injectable } from "@angular/core"
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router"
import { Observable } from "rxjs"
import { Student } from "../../models/student.model"
import { MajorService } from "../../services/major.service"
import { MajorStudentsDto } from "../../models/dto/MajorStudentsDto"

@Injectable({
  providedIn: "root",
})
export class MajorStudentsResolver implements Resolve<MajorStudentsDto> {
  constructor(private majorService: MajorService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<MajorStudentsDto> {
    return this.majorService.findStudentsFromMajor(route.params["id"])
  }
}
