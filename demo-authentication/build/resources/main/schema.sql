--DROP TABLE IF EXISTS users;
--DROP TABLE IF EXISTS authorities;
--DROP TABLE IF EXISTS challenges;

CREATE TABLE users (
    login_id INTEGER ,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (username)
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
    ON authorities (username, authority);


CREATE TABLE challenges(
    id          INTEGER NOT NULL PRIMARY KEY,
    title       VARCHAR(50),
    description   VARCHAR(50),
    credits  INTEGER
);

CREATE TABLE rewards(
    id           INTEGER NOT NULL PRIMARY KEY,
    name       VARCHAR(50),
    description       VARCHAR(50),
    url       VARCHAR(50),
    credits INTEGER
);
CREATE TABLE user_challenge(
    id    INTEGER NOT NULL PRIMARY KEY,
    challenge_id    INTEGER,
    login_id    INTEGER,
    status VARCHAR(20)
);

CREATE TABLE user_reward(
  login_id    INTEGER,
  reward_id    INTEGER
);

