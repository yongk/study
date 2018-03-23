DROP TABLE IF EXISTS blog;
DROP TABLE IF EXISTS author;


CREATE TABLE author (
  id_ INT NOT NULL ,
  username_ VARCHAR(20),
  CONSTRAINT pk_author PRIMARY KEY (id_)
);

CREATE TABLE blog (
  id_ INT NOT NULL ,
  title_ VARCHAR(256) NOT NULL,
  author_id_ INT ,
  CONSTRAINT pk_blog PRIMARY KEY (id_),
  CONSTRAINT fk_author FOREIGN KEY (author_id_) REFERENCES author (id_) ON DELETE RESTRICT ON UPDATE RESTRICT
);


INSERT INTO author (id_, username_) VALUES (1, 'admin');
INSERT INTO author (id_, username_) VALUES (2, 'lucy');
INSERT INTO author (id_, username_) VALUES (3, null);

INSERT INTO blog (id_, title_, author_id_) VALUES (1, '碎碎念', 1);
INSERT INTO blog (id_, title_, author_id_) VALUES (2, '杂碎后院', 3);
