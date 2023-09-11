import { Course } from "./course.model"
import { Major } from "./major.model"

export class Student {
  id?: bigint
  firstName: string
  lastName: string
  birthDate?: Date
  courses?: Course[]
  major: Major

  constructor(firstName: string, lastName: string, major: Major, birthDate?: Date, courses?: Course[], id?: bigint) {
    this.id = id
    this.firstName = firstName
    this.lastName = lastName
    this.birthDate = birthDate
    this.courses = courses
    this.major = major
  }
}
