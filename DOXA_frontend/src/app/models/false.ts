import { Post } from './post';
import { User } from './user';

export interface False {
  idFalse: number; // Identifiant du faux (False)
  post: Post; // Post associé au faux
  user: User; // Utilisateur qui a cliqué sur FALSE
  date: Date; // Date du clic sur FALSE
}
