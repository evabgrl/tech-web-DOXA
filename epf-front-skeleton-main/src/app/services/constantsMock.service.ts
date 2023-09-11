import { Injectable } from "@angular/core"
import { Student } from "../models/student.model"
import { Course } from "../models/course.model"
import { Major } from "../models/major.model"

@Injectable({
  providedIn: "root",
})
export class ConstantsMockService {
  constructor() {}
  private spanish = new Course("Spanish", 2)
  private german = new Course("German", 2)
  private ioT = new Course("Internet Of Things", 15)
  private termo = new Course("Thermodynamic", 10)
  private anatomie = new Course("Anatomy", 7)
  private java = new Course("Java", 15)
  private math = new Course("Maths", 30)
  private management = new Course("Lean Management", 30)

  private min = new Major("Ingéniérie du Numérique", "Des lignes de code partout !!", 1n)
  private msm = new Major("Structure & Matériaux", "Beaucoup de béton et des poutres (snif elle a été renomée)", 2n)

  private mae = new Major("Aéronautique & Espace", "Vive le vent", 3n)
  private mde = new Major("Data Engineering", "Trop cool plein de données à ordonner", 4n)
  private mee = new Major("Energie & Environnement", "On est full green", 5n)
  private mem = new Major("Engineering Management", "Des managers de qualité", 6n)
  private mis = new Major("Ingénierie & Santé", "On connait tous les os et tous les muscles du corps humain", 7n)
  private miad = new Major("Ingénierie & Architecture durable", "Objectif 0 carbon", 8n)
  private mdid = new Major("Design Industriel Durable", "Ca existait pas pour la P2022 ça", 9n)

  student1 = new Student("Harry", "Cover", this.mem, new Date("1998-10-10"), [this.spanish, this.management], 1n)
  student2 = new Student("Jacques", "Climate", this.mee, new Date("1999-11-07"), [this.german, this.termo], 2n)
  student3 = new Student("Alain", "Parfait", this.min, new Date("1999-04-12"), [this.german, this.ioT, this.java], 3n)
  student4 = new Student("Cathy", "Mini", this.mde, new Date("1999-05-12"), [this.spanish, this.math, this.java], 4n)
  student5 = new Student(
    "Côme",
    "Toulemonde",
    this.mis,
    new Date("1999-07-16"),
    [this.spanish, this.anatomie, this.math],
    5n,
  )

  students: Student[] = [this.student1, this.student2, this.student3, this.student4, this.student5]
  majors: Major[] = [this.min, this.msm, this.mae, this.mde, this.mee, this.mem, this.mis, this.miad, this.mdid]
  courses: Course[] = [this.spanish, this.german, this.ioT, this.termo, this.anatomie, this.math, this.java, this.management]
}
