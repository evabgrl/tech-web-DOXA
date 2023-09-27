import { Injectable } from "@angular/core"
import { Student } from "models/student.model"
import { Course } from "models/course.model"
import { Major } from "models/major.model"

@Injectable({
  providedIn: "root",
})
export class ConstantsMockService {
  constructor() {
  }

  private spanish: Course = {name: "Spanish", hours: 2}
  private german: Course = {name: "German", hours: 2}
  private ioT: Course = {name: "Internet Of Things", hours: 15}
  private termo: Course = {name: "Thermodynamic", hours: 10}
  private anatomie: Course = {name: "Anatomy", hours: 7}
  private java: Course = {name: "Java", hours: 15}
  private math: Course = {name: "Maths", hours: 30}
  private management: Course = {name: "Lean Management", hours: 30}

  private min: Major = {name: "Ingéniérie du Numérique", description: "Des lignes de code partout !!", id: 1n, students: []}
  private msm: Major = {name: "Structure & Matériaux", description: "Beaucoup de béton et des poutres (snif elle a été renomée)", id: 2n, students: []}

  private mae: Major = {name: "Aéronautique & Espace", description: "Vive le vent", id: 3n, students: []}
  private mde: Major = {name: "Data Engineering", description: "Trop cool plein de données à ordonner", id: 4n, students: []}
  private mee: Major = {name: "Energie & Environnement", description: "On est full green", id: 5n, students: []}
  private mem: Major = {name: "Engineering Management", description: "Des managers de qualité", id: 6n, students: []}
  private mis: Major = {name: "Ingénierie & Santé", description: "On connait tous les os et tous les muscles du corps humain", id: 7n, students: []}
  private miad: Major = {name: "Ingénierie & Architecture durable", description: "Objectif 0 carbon", id: 8n, students: []}
  private mdid: Major = {name: "Design Industriel Durable", description: "Ca existait pas pour la P2022 ça", id: 9n, students: []}

  private student1: Student = {
    firstName: "Harry",
    lastName: "Cover",
    major: this.mem,
    birthdate: new Date("1998-10-10"),
    courses: [this.german, this.termo],
    id: 1n,
  }
  private student2: Student = {
    firstName: "Jacques",
    lastName: "Climate",
    major: this.mee,
    birthdate: new Date("1999-11-07"),
    courses: [this.german, this.termo],
    id: 2n,
  }
  private student3: Student = {
    firstName: "Alain",
    lastName: "Parfait",
    major: this.min,
    birthdate: new Date("1999-04-12"),
    courses: [this.german, this.ioT, this.java],
    id: 3n,
  }
  private student4: Student = {
    firstName: "Cathy",
    lastName: "Mini",
    major: this.mde,
    birthdate: new Date("1999-05-12"),
    courses: [this.spanish, this.math, this.java],
    id: 4n,
  }
  private student5: Student = {
    firstName: "Côme",
    lastName: "Toulemonde",
    major: this.mis,
    birthdate: new Date("1999-07-16"),
    courses: [this.spanish, this.anatomie, this.math],
    id: 5n,
  }

  students: Student[] = [this.student1, this.student2, this.student3, this.student4, this.student5]
  majors: Major[] = [this.min, this.msm, this.mae, this.mde, this.mee, this.mem, this.mis, this.miad, this.mdid]
  courses: Course[] = [this.spanish, this.german, this.ioT, this.termo, this.anatomie, this.math, this.java, this.management]
}
