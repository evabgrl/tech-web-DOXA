import { Component, OnInit, HostListener } from "@angular/core"

import { User } from "models/user"
import { PostService } from "services/post.service"
import { CommentService } from "services/comment.service"
import { MatDialog } from "@angular/material/dialog"
import { Post } from "models/Post"

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})
export class HomeComponent implements OnInit {
  posts: Post[] = []
  nouveauPoste: string = ""
  user!: User[]
  nouveauCommentaire: string = ""
  commentaireEnCours: { [postId: number]: boolean } = {}
  userReachedBottom = false
  commentairesVisibles: { [postId: number]: boolean } = {}
  commentSectionStatus: { [postId: number]: boolean } = {}
  explicationVisible: { [postId: number]: boolean } = {}
  currentUser: User = {
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

  constructor(private postService: PostService, private commentService: CommentService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.getPosts()

    this.posts = [
      {
        idPost: 1,
        date: new Date(),
        user: this.currentUser,
        text: "Ceci était l'anecdote test, mais actuellement ma route a un problème CORS que je ne parviens pas à régler donc je vais mettre quelques anecdotes afin que tu vois le travail effectué",
        comments: [],
        isTrue: true,
      },
      {
        idPost: 2,
        date: new Date(),
        user: this.currentUser,
        text: "En 1889, la reine d'Italie Margherita Savoy a commandé la première livraison de pizza",
        comments: [],
        isTrue: true,
      },
      {
        idPost: 3,
        date: new Date(),
        user: this.currentUser,
        text: "Il y a autant de plis sur la toque d'un chef que de façon de cuire un oeuf",
        comments: [],
        isTrue: true,
      },
      {
        idPost: 4,
        date: new Date(),
        user: this.currentUser,
        text: "les humains ont pour seules empreintes uniques les empreintes digitales",
        comments: [],
        isTrue: false,
      },
    ]
  }
  getPosts(): void {
    this.postService.getAllPosts().subscribe((posts) => {
      console.log(posts)
      this.posts = posts
    })
  }

  // Méthode pour ajouter un nouveau poste
  ajouterPoste() {
    if (this.nouveauPoste.trim() !== "") {
      const currentUser: User = {
        idUser: 1,
        username: "Eva Abgrall",
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
      const nouvelleAnecdote: Post = {
        idPost: this.posts.length + 1,
        date: new Date(),
        user: currentUser,
        text: this.nouveauPoste,
        comments: [],
        isTrue: true,
      }
      this.posts.unshift(nouvelleAnecdote)
      this.commentSectionStatus[nouvelleAnecdote.idPost] = false
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
          username: "Eva Abgrall",
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
  marquerVraie(postId: number) {
    this.explicationVisible[postId] = !this.explicationVisible[postId]
  }

  // Méthode pour marquer une anecdote comme fausse
  marquerFausse(postId: number) {
    this.explicationVisible[postId] = !this.explicationVisible[postId]
  }

  afficherExplication(anecdote: any) {
    this.explicationVisible[anecdote.idPost] = true
  }

  masquerExplication(anecdote: any) {
    this.explicationVisible[anecdote.idPost] = false
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
