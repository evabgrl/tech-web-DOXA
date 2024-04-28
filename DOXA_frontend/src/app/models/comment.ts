import { Post } from './post';
import { User } from './user';

export interface Comment {
  idComment: number; // Identifiant du commentaire
  text: string; // Contenu du commentaire
  user: User; // Utilisateur ayant écrit le commentaire
  post: Post | null; // Anecdote à laquelle le commentaire est associé
  date: Date; // Date du commentaire
}
