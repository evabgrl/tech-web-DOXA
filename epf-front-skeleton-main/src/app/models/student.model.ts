import { Course } from "./course.model"
import { Major } from "./major.model"

export interface Student {
  id?: bigint
  image?: string
  firstName: string
  lastName: string
  birthDate?: Date
  courses?: Course[]
  major: Major
}
