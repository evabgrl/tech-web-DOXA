import { Component, OnInit } from "@angular/core"
import { Link } from "../models/links.model"

@Component({
  selector: "epf-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent implements OnInit {
  links: Link[] = []

  constructor() {
    this.links.push(new Link("Students", "students"))
    this.links.push(new Link("Majors", "majors"))
  }

  ngOnInit(): void {
  }
}
