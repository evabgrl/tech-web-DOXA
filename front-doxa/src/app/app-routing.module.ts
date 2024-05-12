import { NgModule } from "@angular/core"
import { RouterModule, Routes } from "@angular/router"
import { HomeComponent } from "home/home.component"
import { MessageComponent } from "messagerie/message"
import { ProfilComponent } from "profil/profil"

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "profil", component: ProfilComponent },
  { path: "messagerie", component: MessageComponent },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
