-- Table pour stocker les utilisateurs
CREATE TABLE User (
    id_user BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Identifiant unique de l'utilisateur
    username VARCHAR(255) UNIQUE NOT NULL,      -- Nom d'utilisateur unique
    photo VARCHAR(255),                          -- Chemin vers la photo de profil
    description VARCHAR(255),                    -- Description de l'utilisateur
    creation_date TIMESTAMP,                     -- Date de création de l'utilisateur
    is_checked BOOLEAN NOT NULL                  -- Indique si l'utilisateur est vérifié ou non
);

-- Table pour stocker les abonnements (relations suivre/suivi)
CREATE TABLE Abonnement (
    id_followership BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Identifiant unique de l'abonnement
    id_user_checked BIGINT NOT NULL,                     -- ID de l'utilisateur suivi
    id_user_follower BIGINT NOT NULL,                    -- ID de l'utilisateur qui suit
    FOREIGN KEY (id_user_checked) REFERENCES User(id_user),    -- Clé étrangère vers l'utilisateur suivi
    FOREIGN KEY (id_user_follower) REFERENCES User(id_user)    -- Clé étrangère vers l'utilisateur qui suit
);

-- Table pour stocker les publications
CREATE TABLE Post (
    id_post BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Identifiant unique de la publication
    text VARCHAR(255),                          -- Contenu textuel de la publication
    id_user BIGINT NOT NULL,                     -- ID de l'utilisateur qui a publié
    date TIMESTAMP NOT NULL,                     -- Date de publication
    is_true BOOLEAN NOT NULL,                   -- Indique si la publication est vraie ou fausse
    FOREIGN KEY (id_user) REFERENCES User(id_user)  -- Clé étrangère vers l'utilisateur qui a publié
);

-- Table pour stocker les commentaires sur les publications
CREATE TABLE Comment (
    id_comment BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Identifiant unique du commentaire
    text VARCHAR(255) NOT NULL,                    -- Contenu textuel du commentaire
    id_user BIGINT NOT NULL,                       -- ID de l'utilisateur qui a commenté
    id_post BIGINT,                                -- ID de la publication commentée
    date TIMESTAMP NOT NULL,                       -- Date du commentaire
    FOREIGN KEY (id_user) REFERENCES User(id_user),    -- Clé étrangère vers l'utilisateur qui a commenté
    FOREIGN KEY (id_post) REFERENCES Post(id_post)     -- Clé étrangère vers la publication commentée
);

-- Table pour stocker les messages privés entre utilisateurs
CREATE TABLE Message (
    id_message BIGINT PRIMARY KEY AUTO_INCREMENT,      -- Identifiant unique du message
    text VARCHAR(255) NOT NULL,                        -- Contenu textuel du message
    id_user_transmitter BIGINT NOT NULL,                -- ID de l'utilisateur qui a envoyé le message
    id_user_receiver BIGINT NOT NULL,                   -- ID de l'utilisateur qui a reçu le message
    date TIMESTAMP NOT NULL,                            -- Date d'envoi du message
    FOREIGN KEY (id_user_transmitter) REFERENCES User(id_user),    -- Clé étrangère vers l'utilisateur émetteur
    FOREIGN KEY (id_user_receiver) REFERENCES User(id_user)        -- Clé étrangère vers l'utilisateur récepteur
);

-- Table pour stocker les réponses considérées comme True
CREATE TABLE True (
    id_true BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Identifiant unique du True
    id_post BIGINT NOT NULL,                     -- ID de la publication 
    id_user BIGINT NOT NULL,                     -- ID de l'utilisateur 
    date TIMESTAMP,                             -- Date du True
    FOREIGN KEY (id_post) REFERENCES Post(id_post),    -- Clé étrangère vers la publication
    FOREIGN KEY (id_user) REFERENCES User(id_user)     -- Clé étrangère vers l'utilisateur
);

-- Table pour stocker les réponses considérées comme False
CREATE TABLE False (
    id_false BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Identifiant unique du False
    id_post BIGINT NOT NULL,                     -- ID de la publication 
    id_user BIGINT NOT NULL,                     -- ID de l'utilisateur
    date TIMESTAMP,                             -- Date du False
    FOREIGN KEY (id_post) REFERENCES Post(id_post),    -- Clé étrangère vers la publication
    FOREIGN KEY (id_user) REFERENCES User(id_user)     -- Clé étrangère vers l'utilisateur
);
