-- Insertions dans la table User
INSERT INTO User (username, photo, description, creation_date, is_checked)
VALUES ('eabgrall', 'https://i.pinimg.com/originals/e4/18/e2/e418e22729bd7a202c563e08463b6ad9.jpg', 'Description', '2024-05-12 08:00:00', true),
       ('kzenat', 'https://i.pinimg.com/originals/7b/38/43/7b3843fac19fdd6fec7e51769e240799.jpg', 'Description', '2024-05-12 08:00:00', true),
       ('eromero', 'https://i.pinimg.com/originals/1a/60/53/1a605385f3fd615edff94f77f3741721.jpg', 'Description', '2024-05-12 08:00:00', true);

-- Insertions dans la table Abonnement
INSERT INTO Abonnement (id_folowership, id_user_checked, id_user_follower)
VALUES (1, 1, 2),  -- Utilisateur 1 suit utilisateur 2
       (2, 2, 3); -- Utilisateur 2 suit utilisateur 3

-- Insertions dans la table Post
INSERT INTO Post (text, id_user, date, is_true)
VALUES ('En 1889, la reine d’Italie Margherita Savoy a commandé la première livraison de pizza', '2024-05-12 08:00:00', 1, true, true),
       ('les humains ont pour seules empreintes uniques les empreintes digitales', '2024-05-12 09:00:00', 2, false, false),
       ('Il est interdit de se tenir à moins de 90m du roi sans chaussettes' , '2024-05-12 10:00:00', true, true),
       ('Il y a autant de plis sur la toque d’un chef que de façon de cuire un oeuf' , '2024-05-12 10:00:00', true, true),
       ('L’Everest perd en hauteur chaque année', '2024-05-12 10:00:00', false, false),
       ('Dans les années 1700, le Comte de Sandwich, trop occupé à jouer, créa le fameux sandwich afin de pouvoir se restaurer sans quitter la table de jeux' , '2024-05-12 10:00:00', true, true);



       

-- Insertions dans la table Comment
INSERT INTO Comment (text, id_user, id_post, date)
VALUES ('Je trouve cela très intéressant', 1, 1, NOW()),
       ('Surprenant, une nouvelle chose apprise en ce jour', 2, 2, NOW()),
       ('En es-tu sur ?', 3, 3, NOW());


-- Insertions dans la table True (adaptées à votre logique métier)
INSERT INTO True (id_post, id_user, date)
VALUES (1, 1, NOW()), -- Publication 1 est considérée comme vraie par l'utilisateur 1
       (3, 2, NOW()); -- Publication 3 est considérée comme vraie par l'utilisateur 2

-- Insertions dans la table False (adaptées à votre logique métier)
INSERT INTO False (id_post, id_user, date)
VALUES (2, 1, NOW()), -- Publication 2 est considérée comme fausse par l'utilisateur 1
       (2, 3, NOW()); -- Publication 2 est considérée comme fausse par l'utilisateur 3
