-- Insertions dans la table User
INSERT INTO User (username, photo, description, creation_date, is_checked)
VALUES ('utilisateur1', 'chemin/photo1.jpg', 'Description 1', NOW(), true),
       ('utilisateur2', 'chemin/photo2.jpg', 'Description 2', NOW(), false),
       ('utilisateur3', 'chemin/photo3.jpg', 'Description 3', NOW(), true);

-- Insertions dans la table Abonnement
INSERT INTO Abonnement (id_folowership, id_user_checked, id_user_follower)
VALUES (1, 1, 2),  -- Utilisateur 1 suit utilisateur 2
       (2, 2, 3); -- Utilisateur 2 suit utilisateur 3

-- Insertions dans la table Post
INSERT INTO Post (text, id_user, date, is_true)
VALUES ('Contenu de la publication 1', 1, NOW(), true),
       ('Contenu de la publication 2', 2, NOW(), false),
       ('Contenu de la publication 3', 3, NOW(), true);

-- Insertions dans la table Comment
INSERT INTO Comment (text, id_user, id_post, date)
VALUES ('Commentaire user1 sur la publication 1', 1, 1, NOW()),
       ('Commentaire user2 sur la publication 2', 2, 2, NOW()),
       ('Commentaire user3 sur la publication 3', 3, 3, NOW());

-- Insertions dans la table Message
INSERT INTO Message (text, id_user_transmitter, id_user_receiver, date)
VALUES ('Message de user1 à user2', 1, 2, NOW()),
       ('Message de user2 à user3', 2, 3, NOW()),
       ('Message de user3 à user1', 3, 1, NOW());

-- Insertions dans la table True (adaptées à votre logique métier)
INSERT INTO True (id_post, id_user, date)
VALUES (1, 1, NOW()), -- Publication 1 est considérée comme vraie par l'utilisateur 1
       (3, 2, NOW()); -- Publication 3 est considérée comme vraie par l'utilisateur 2

-- Insertions dans la table False (adaptées à votre logique métier)
INSERT INTO False (id_post, id_user, date)
VALUES (2, 1, NOW()), -- Publication 2 est considérée comme fausse par l'utilisateur 1
       (2, 3, NOW()); -- Publication 2 est considérée comme fausse par l'utilisateur 3
