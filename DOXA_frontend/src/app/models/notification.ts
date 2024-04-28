import { Comment } from './comment';
import { Abonnement } from './abonnement';
import { Post } from './post';
import { User } from './user';

export class Notification {
  idNotification: number;
  isViewed: boolean;
  type: string;
  friend: User;
  userTransmitter: User;
  post: Post;
  comment: Comment;
  abonnement: Abonnement;
  date: Date;
}
