import { Component, OnInit, HostListener } from "@angular/core"
import { Post } from "models/post"
import { User } from "models/user"
import { PostService } from "services/post.service"
import { CommentService } from "services/comment.service"
import { MatDialog } from "@angular/material/dialog"
import { PopinComponent } from "popin/popin.component"

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})
export class HomeComponent implements OnInit {
  anecdotes: Post[] = []
  nouveauPoste: string = ""
  user!: User[]
  nouveauCommentaire: string = ""
  commentaireEnCours: { [postId: number]: boolean } = {}
  userReachedBottom = false
  commentairesVisibles: { [postId: number]: boolean } = {}

  constructor(private postService: PostService, private commentService: CommentService, private dialog: MatDialog) {}

  ngOnInit(): void {
    // Simuler des données d'anecdotes
    this.anecdotes = [
      {
        idPost: 1,
        date: new Date(),
        user: this.user,
        text: "Contenu de la nouvelle anecdote",
        comments: [],
        reactions: [],
        isTrue: true,
      },
      {
        idPost: 2,
        date: new Date(),
        user: this.user,
        text: "Contenu de la 2eme anecdote",
        comments: [],
        reactions: [],
        isTrue: true,
      },
      {
        idPost: 3,
        date: new Date(),
        user: this.user,
        text: "Contenu de la 3eme anecdote",
        comments: [],
        reactions: [],
        isTrue: true,
      },
      {
        idPost: 4,
        date: new Date(),
        user: this.user,
        text: "Contenu de la 4eme anecdote",
        comments: [],
        reactions: [],
        isTrue: true,
      },
    ]
  }

  // Méthode pour ajouter un nouveau poste
  ajouterPoste() {
    if (this.nouveauPoste.trim() !== "") {
      const nouvelleAnecdote: Post = {
        idPost: this.anecdotes.length + 1,
        date: new Date(),
        user: this.user,
        text: this.nouveauPoste,
        comments: [],
        reactions: [],
        isTrue: true,
      }
      this.anecdotes.unshift(nouvelleAnecdote)
      this.nouveauPoste = ""
    }
  }

  // Méthode pour ajouter un nouveau commentaire
  ajouterCommentaire(post: Post) {
    if (this.commentaireEnCours[post.idPost]) {
      if (this.nouveauCommentaire.trim() !== "") {
        // Simuler un utilisateur pour le commentaire
        const currentUser: User = {
          idUser: 1,
          username: "John Doe",
          photo: "assets/téléchargement(1).jpg",
          description: "Description de l'utilisateur",
          creationDate: new Date(),
          isChecked: false,
          notifications: [],
          comments: [],
          following: [],
          followers: [],
          likes: [],
          messagesTransmitted: [],
          messagesReceived: [],
          posts: [],
        }
        // Ajouter le commentaire au service de commentaires
        this.commentService.addComment(post, currentUser, this.nouveauCommentaire)
        this.nouveauCommentaire = ""
      }
    } else {
      this.commentaireEnCours[post.idPost] = true
    }
  }

  // Méthode pour marquer une anecdote comme vraie
  marquerVraie(anecdote: Post) {
    this.afficherPopin("Marquer l'anecdote comme vraie", anecdote)
  }

  // Méthode pour marquer une anecdote comme fausse
  marquerFausse(anecdote: Post) {
    this.afficherPopin("Marquer l'anecdote comme fausse", anecdote)
  }

  // Méthode pour afficher la popin de confirmation
  afficherPopin(message: string, anecdote: Post) {
    const dialogRef = this.dialog.open(PopinComponent, {
      width: "250px",
      data: { message: message },
    })

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        // Si l'utilisateur confirme, effectuez l'action correspondante
        if (message.includes("vraie")) {
          anecdote.isTrue = true
        } else if (message.includes("fausse")) {
          anecdote.isTrue = false
        }
      }
    })
  }

  // Méthode pour détecter si l'utilisateur a atteint le bas de la page
  @HostListener("window:scroll", [])
  onWindowScroll() {
    if (window.innerHeight + window.scrollY >= document.body.offsetHeight) {
      this.userReachedBottom = true
    } else {
      this.userReachedBottom = false
    }
  }

  toggleCommentaires(postId: number) {
    this.commentairesVisibles[postId] = !this.commentairesVisibles[postId]
  }
}
