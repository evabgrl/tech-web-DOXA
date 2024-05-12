import { User } from "./user"

export interface Message {
  idMessage: number // Identifiant du message
  text: string // Contenu du message
  userTransmitter: User // Utilisateur ayant envoyé le message
  userReceiver: User // Utilisateur ayant reçu le message
  date: Date // Date d'envoi du message
}
