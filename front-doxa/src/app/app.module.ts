import { NgModule } from "@angular/core"
import { BrowserModule } from "@angular/platform-browser"

import { AppRoutingModule } from "app-routing.module"
import { AppComponent } from "app.component"
import { BrowserAnimationsModule } from "@angular/platform-browser/animations"
import { NavbarComponent } from "navbar/navbar.component"
import { MatListModule } from "@angular/material/list"
import { HomeComponent } from "home/home.component"
import { FormsModule } from "@angular/forms"
import { MatIconModule } from "@angular/material/icon"
import { MatButtonModule } from "@angular/material/button"
import { HttpClientModule } from "@angular/common/http"
import { MatAutocompleteModule } from "@angular/material/autocomplete"
import { MessageComponent } from "messagerie/message"
import { PopinComponent } from "popin/popin.component"

@NgModule({
  declarations: [AppComponent, NavbarComponent, HomeComponent, MessageComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatListModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    HttpClientModule,
    MatAutocompleteModule,
    PopinComponent,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
