import { Component, Input } from "@angular/core"

@Component({
  selector: "popin",
  standalone: true,
  imports: [],
  templateUrl: "./popin.component.html",
  styleUrl: "./popin.component.scss",
})
export class PopinComponent {
  @Input() popinTitle: string = ""
  @Input() popinMessage: string = ""
  @Input() popinExplanation: string = ""
  popinOpen: boolean = false

  closePopin() {
    this.popinOpen = false // Mettre la variable à false pour fermer la popin
  }
}
