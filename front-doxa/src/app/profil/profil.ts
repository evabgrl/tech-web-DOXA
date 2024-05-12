import { Component, OnInit } from "@angular/core"
import { ActivatedRoute } from "@angular/router"
import { UserService } from "services/user.service"
import { User } from "models/user"

@Component({
  selector: "app-profil",
  templateUrl: "./profil.html",
  styleUrls: ["./profil.scss"],
})
export class ProfilComponent implements OnInit {
  user: User | undefined

  constructor(private route: ActivatedRoute, private userService: UserService) {}

  ngOnInit(): void {
    this.getUserProfile()
  }

  getUserProfile(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"))

    this.userService.getUserById(id).subscribe((user) => {
      this.user = user
    })
  }
}
