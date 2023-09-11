import { Student } from "./student.model"

export class Major {
  id?: bigint
  name: string
  description: string
  students: Student[] = []

  constructor(name: string, description: string, id?: bigint) {
    this.name = name
    this.description = description
    this.id = id
  }
}
