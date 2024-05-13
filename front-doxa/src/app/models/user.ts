import { Post } from "./Post"
import { Comment } from "./comment"
import { Abonnement } from "./abonnement"
import { True } from "./true"
import { Message } from "./message"

export interface User {
  idUser: number // Identifiant de l'utilisateur
  username: string // Nom d'utilisateur
  photo: string // Photo de l'utilisateur
  description: string // Description de l'utilisateur
  creationDate: Date // Date de création du compte
  isChecked: boolean // Indique si l'utilisateur est vérifié
  notifications: Notification[] // Liste des notifications de l'utilisateur
  comments: Comment[] // Liste des commentaires de l'utilisateur
  following: Abonnement[] // Liste des abonnements suivis par l'utilisateur
  followers: Abonnement[] // Liste des abonnements qui suivent l'utilisateur
  likes: True[] // Liste des likes donnés par l'utilisateur
  messagesTransmitted: Message[] // Liste des messages envoyés par l'utilisateur
  messagesReceived: Message[] // Liste des messages reçus par l'utilisateur
  posts: Post[] // Liste des posts créés par l'utilisateur
}
