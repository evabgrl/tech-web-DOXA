import { Component, Input } from "@angular/core"

@Component({
  selector: "popin",
  templateUrl: "./popin.component.html",
  styleUrl: "./popin.component.scss",
})
export class PopinComponent {
  @Input() popinTitle: string = ""
  @Input() popinMessage: string = ""
  @Input() popinExplanation: string = ""
  popinOpen: boolean = false

  openPopin() {
    this.popinOpen = true
  }
  closePopin() {
    this.popinOpen = false // Mettre la variable à false pour fermer la popin
  }
}
