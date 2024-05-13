-- Insertions dans la table UserDoxa
INSERT INTO UserDoxa (id_user, username, photo, description, creation_date, is_checked)
VALUES 
(1, 'eabgrall', 'https://i.pinimg.com/originals/e4/18/e2/e418e22729bd7a202c563e08463b6ad9.jpg', 'Description', '2024-05-12 08:00:00', true),
(2, 'kzenat', 'https://i.pinimg.com/originals/7b/38/43/7b3843fac19fdd6fec7e51769e240799.jpg', 'Description', '2024-05-12 08:00:00', true),
(3, 'eromero', 'https://i.pinimg.com/originals/1a/60/53/1a605385f3fd615edff94f77f3741721.jpg', 'Description', '2024-05-12 08:00:00', true);

-- Insertions dans la table Abonnement
INSERT INTO Abonnement (id_followership, id_user_checked, id_user_follower)
VALUES 
(1, 1, 2), -- Utilisateur 1 suit utilisateur 2
(2, 2, 3); -- Utilisateur 2 suit utilisateur 3

-- Insertions dans la table Post
INSERT INTO Post (id_post, text, id_user, date, is_true)
VALUES 
(1, 'En 1889, la reine d’Italie Margherita Savoy a commandé la première livraison de pizza', 1, '2024-05-12 08:00:00', true),
(2, 'les humains ont pour seules empreintes uniques les empreintes digitales', 2, '2024-05-12 09:00:00', false),
(3, 'Il est interdit de se tenir à moins de 90m du roi sans chaussettes', 3, '2024-05-12 10:00:00', true),
(4, 'Il y a autant de plis sur la toque d’un chef que de façon de cuire un oeuf', 1, '2024-05-12 10:00:00', true),
(5, 'L’Everest perd en hauteur chaque année', 2, '2024-05-12 10:00:00', false),
(6, 'Dans les années 1700, le Comte de Sandwich, trop occupé à jouer, créa le fameux sandwich afin de pouvoir se restaurer sans quitter la table de jeux', 3, '2024-05-12 10:00:00', true);

-- Insertions dans la table Comment
INSERT INTO Comment (id_comment, text, id_user, id_post, date)
VALUES 
(1, 'Je trouve cela très intéressant', 1, 1, NOW()),
(2, 'Surprenant, une nouvelle chose apprise en ce jour', 2, 2, NOW()),
(3, 'En es-tu sur ?', 3, 3, NOW());

-- Insertions dans la table Message
INSERT INTO Message (id_message, text, id_user_transmitter, id_user_receiver, date)
VALUES 
(1, 'Salut ! Comment ça va ?', 1, 2, NOW()),
(2, 'Très bien merci, et toi ?', 2, 1, NOW());

-- Insertions dans la table TrueDoxa
INSERT INTO TrueDoxa (id_true, id_post, id_user, date)
VALUES 
(1, 1, 1, NOW()),
(2, 2, 2, NOW());

-- Insertions dans la table FalseDoxa
INSERT INTO FalseDoxa (id_false, id_post, id_user, date)
VALUES 
(1, 3, 1, NOW()),
(2, 3, 3, NOW());
