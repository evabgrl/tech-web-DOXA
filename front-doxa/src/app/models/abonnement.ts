import { User } from "./user"

export interface Abonnement {
  idFollowership: number // Identifiant du suivi
  userChecked: User // Utilisateur suivi
  userFollower: User // Utilisateur suiveur
}
