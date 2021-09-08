-- User user/pass
INSERT INTO users (login_id, username, password, enabled)
    VALUES (1,'user1', 'a', 1);

INSERT INTO users (login_id,username, password, enabled)
    VALUES (2,'user2', 'b', 1);

INSERT INTO authorities (username, authority)
    VALUES ('user1', 'ROLE_USER');

INSERT INTO authorities (username, authority)
    VALUES ('user2', 'ROLE_ADMIN');


INSERT INTO challenges (id, title, description, credits)
    VALUES (1,'titlu1','descriere1',50);

INSERT INTO challenges (id, title, description, credits)
    VALUES (2,'titlu2','descriere2',50);

INSERT INTO challenges (id, title, description, credits)
    VALUES (3,'titlu3','descriere3',50);


INSERT INTO rewards (id, name, description, url, credits)
    VALUES (1,'nume1','descriere1','url1',50);
INSERT INTO rewards (id, name, description, url, credits)
    VALUES (2,'nume2','descriere2','url2',50);
INSERT INTO rewards (id, name, description, url, credits)
    VALUES (3,'nume3','descriere3','url3',50);

INSERT INTO user_challenge(id, challenge_id,login_id,status)
    VALUES (1,1,1,'ENROLLED');
INSERT INTO user_challenge(id, challenge_id,login_id,status)
    VALUES (2,2,2,'ENROLLED');
INSERT INTO user_challenge(id, challenge_id,login_id,status)
    VALUES (3,3,3,'ENROLLED');


INSERT INTO user_reward(login_id,reward_id)
    VALUES (1,1);
INSERT INTO user_reward(login_id,reward_id)
    VALUES (2,2);
INSERT INTO user_reward(login_id,reward_id)
    VALUES (3,3);





