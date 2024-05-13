CREATE TABLE UserDoxa (
    id_user BIGSERIAL PRIMARY KEY, 
    username VARCHAR(255) UNIQUE NOT NULL,   
    photo VARCHAR(255),                       
    description VARCHAR(255),             
    creation_date TIMESTAMP,                  
    is_checked BOOLEAN NOT NULL                
);

CREATE TABLE Abonnement (
    id_followership BIGSERIAL PRIMARY KEY, 
    id_user_checked BIGINT NOT NULL,                    
    id_user_follower BIGINT NOT NULL,            
    FOREIGN KEY (id_user_checked) REFERENCES UserDoxa(id_user),   
    FOREIGN KEY (id_user_follower) REFERENCES UserDoxa(id_user)    
);

CREATE TABLE Post (
    id_post BIGSERIAL PRIMARY KEY,  
    text VARCHAR(255),                       
    id_user BIGINT NOT NULL,                    
    date TIMESTAMP NOT NULL,                    
    is_true BOOLEAN NOT NULL,                   
    FOREIGN KEY (id_user) REFERENCES UserDoxa(id_user)  
);

CREATE TABLE Comment (
    id_comment BIGSERIAL PRIMARY KEY,  
    text VARCHAR(255) NOT NULL,                    
    id_user BIGINT NOT NULL,                       
    id_post BIGINT,                                
    date TIMESTAMP NOT NULL,                       
    FOREIGN KEY (id_user) REFERENCES UserDoxa(id_user),   
    FOREIGN KEY (id_post) REFERENCES Post(id_post)     
);

CREATE TABLE Message (
    id_message BIGSERIAL PRIMARY KEY,      
    text VARCHAR(255) NOT NULL,                        
    id_user_transmitter BIGINT NOT NULL,                
    id_user_receiver BIGINT NOT NULL,                   
    date TIMESTAMP NOT NULL,                            
    FOREIGN KEY (id_user_transmitter) REFERENCES UserDoxa(id_user),    
    FOREIGN KEY (id_user_receiver) REFERENCES UserDoxa(id_user)        
);

CREATE TABLE TrueDoxa (
    id_true BIGSERIAL PRIMARY KEY,  
    id_post BIGINT NOT NULL,                     
    id_user BIGINT NOT NULL,                     
    date TIMESTAMP,                             
    FOREIGN KEY (id_post) REFERENCES Post(id_post),    
    FOREIGN KEY (id_user) REFERENCES UserDoxa(id_user)     
);

CREATE TABLE FalseDoxa (
    id_false BIGSERIAL PRIMARY KEY,  
    id_post BIGINT NOT NULL,                     
    id_user BIGINT NOT NULL,                     
    date TIMESTAMP,                             
    FOREIGN KEY (id_post) REFERENCES Post(id_post),    
    FOREIGN KEY (id_user) REFERENCES UserDoxa(id_user)     
);
