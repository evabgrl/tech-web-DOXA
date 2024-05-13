# Projet DOXA

## Description
Bienvenue sur DOXA, l'application qui a survécu à plus de réunions et de tasses de café qu'il n'est humainement acceptable. Ici, nous vous offrons une plateforme sociale sans admin pour prouver que l'anarchie peut fonctionner (spoiler : ça dépend des jours). DOXA, le coin numérique où le quotidien se transforme en légende. Notre réseau social est dédié à la publication d'anecdotes par les internautes. De l'insolite au merveilleux, chaque histoire est un secret à découvrir – pas de spoilers pour les meilleures publications, vous devrez les découvrir par vous-même !

## Technologies utilisées
- *Frontend* : Angular JS, parce qu'on aime les challenges et un peu de souffrance.
- *Backend* : Java avec Spring Boot, pour ceux qui apprécient les bonnes vieilles traditions.
- *Base de données* : PostgreSQL, le seul et unique, robuste et fidèle, sauf quand il décide de l'être moins.
- *Conteneurisation* : Docker, pour empêcher notre app de saccager votre précieux système.

## Prérequis
- *Docker* : Parce qu'essayer de gérer les dépendances manuellement, c'est tellement 2010. Installez-le à partir de [Docker Hub](https://hub.docker.com/).
- *Node.js* : Nécessaire pour faire tourner le hamster dans la roue qui génère le code Angular. Téléchargez-le depuis [Node.js](https://nodejs.org/).
- *JDK Java* : Sans lui, notre backend serait juste une coquille vide. Téléchargez la dernière version d'[Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html), ou une distribution Open Source comme [OpenJDK](https://jdk.java.net/).
- *Eclipse* : Parce que parfois, nous aimons voir le monde brûler. Mais sérieusement, pour une bonne intégration avec Spring Boot, c'est top.

## Configuration (le moment de vérité)
   *Cloner le dépôt* :
   Ouvrez un terminal et exécutez:
   bash
   git clone https://github.com/voilaVotreRepo.git

Remplacez https://github.com/voilaVotreRepo.git par votre URL, évidemment.

    Ouvrez Eclipse :
        Importez le projet en utilisant File > Import > Existing Projects into Workspace.
        Faites un clic droit sur le projet, choisissez Run As > Spring Boot App. Eclipse s'occupera de vous rappeler pourquoi vous l'aimez (ou pas).

    Lancez Docker Compose :
        Assurez-vous que Docker tourne aussi rond que possible.
        Exécutez dans le terminal du projet :

        bash

        docker-compose up --build

        Cette étape peut prendre un peu de temps. C'est le moment idéal pour une pause café.

    Accédez à l'application :
        Tapez http://localhost:4200/ dans votre navigateur après avoir prié pour aucun bug.

## Comment utiliser DOXA sans perdre vos amis

    Soyez gentil, c'est un réseau social après tout.
    Ne spammez pas de GIFs de chats, même si c'est tentant.
    Résistez à l'envie de corriger les fautes d'orthographe des autres, ça ne finit jamais bien.

## Contribution

Si vous souhaitez contribuer, n'oubliez pas de forker le dépôt. Créez votre propre branche de fonctionnalités, apportez vos améliorations (nous savons que vous en mourrez d'envie), et envoyez-nous une pull request. On adore les surprises !
Équipe de développement

    Eva Abgrall (eva.abgrall@edu.ece.fr) - La maestro du code qui ne dort jamais.
    ZENAT Kaïs (kais.zenat@edu.ece.fr) - Le bug hunter en chef.
    ROMERO Enzo (enzo.romero@edu.ece.fr) - L'artiste qui pense que CSS est une forme d'art moderne.

## Licence

Tous droits réservés. Faites-en bon usage, nous vous surveillons !

## Contact

Si vous avez des questions, des suggestions, ou juste envie de discuter, n'hésitez pas à contacter notre équipe. Sauf entre 13h et 14h, c'est sacré, c'est l'heure du déjeuner.
