import { Course } from "./course.model"
import { Major } from "./major.model"

export interface Student {
  id?: bigint
  firstName: string
  lastName: string
  birthDate?: Date
  courses?: Course[]
  major: Major
}
