import { Post } from './post';
import { User } from './user';

export interface True {
  idTrue: number; // Identifiant du vrai (True)
  post: Post; // Post associé au vrai
  user: User; // Utilisateur qui a cliqué sur TRUE
  date: Date; // Date du clic sur TRUE
}
