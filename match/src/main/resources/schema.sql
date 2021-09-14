CREATE TABLE MATCH_USERS (
  id CHAR(36) NOT NULL,
  name VARCHAR(50) NOT NULL,
  nick VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE PLAYERS (
  id CHAR(36) NOT NULL,
  user_id CHAR(36) NOT NULL,
  league_id CHAR(36) NOT NULL,
  PRIMARY KEY (id)
);
