CREATE TABLE user (
  id BIGINT NOT NULL,
  name VARCHAR(20),
  age TINYINT
);
ALTER TABLE user ADD CONSTRAINT pk_user PRIMARY KEY (id);