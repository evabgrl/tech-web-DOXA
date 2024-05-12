import { User } from "./user"
import { Comment } from "./comment"

export interface Post {
  idPost: number // Identifiant du post
  text: string // Contenu du post
  date: Date // Date de création du post
  user: User[] // Utilisateur ayant créé le post
  comments: Comment[] // Liste des commentaires associés au post
  isTrue: boolean // Indique si le post est vrai ou faux
  reactions: Reaction[]
}

export interface Reaction {
  idReaction: number
  user: User
  reaction: boolean // true pour "True", false pour "False"
}
