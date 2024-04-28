import { User } from './user';
import { Notification } from './notification';

export interface Abonnement {
  idFollowership: number; // Identifiant du suivi
  userChecked: User; // Utilisateur suivi
  userFollower: User; // Utilisateur suiveur
  notifications: Notification[]; // Liste des notifications liées à cet abonnement
}
