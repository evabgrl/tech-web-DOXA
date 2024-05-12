import { Component, Input, OnInit } from "@angular/core"
import { FormControl } from "@angular/forms"
import { MatAutocompleteSelectedEvent } from "@angular/material/autocomplete"
import { Router } from "@angular/router"
import { Observable } from "rxjs"
import { User } from "models/user"

import { UserService } from "services/user.service"

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent implements OnInit {
  public placeholder: string | undefined
  public people: Observable<User[]> | undefined
  control = new FormControl()

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.people = this.userService.getAllUsers()
  }

  public goToProfile(event: MatAutocompleteSelectedEvent) {
    let user = event.option.value as User
    this.router.navigate(["/profile", user.idUser])
    this.control.setValue("")
    event.option.focus()
    event.option.deselect()
  }
}
