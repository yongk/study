DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;


CREATE TABLE user (
  username_ VARCHAR(20) NOT NULL ,
  description_ VARCHAR(40) ,
  CONSTRAINT pk_user PRIMARY KEY (username_)
);

-- user与role是一对多的关系
CREATE TABLE role (
  name_ VARCHAR(20) NOT NULL ,
  user_ VARCHAR(20) NOT NULL ,
  description_ VARCHAR(40) ,
  CONSTRAINT pk_role PRIMARY KEY (name_) ,
  CONSTRAINT fk_user FOREIGN KEY (user_) REFERENCES user (username_) ON UPDATE RESTRICT ON DELETE RESTRICT
);


INSERT INTO user (username_, description_) VALUES ('admin', '管理员');
INSERT INTO user (username_, description_) VALUES ('lucy', null);

INSERT INTO role (name_, user_, description_) VALUES ('admin', 'admin', '管理员');
INSERT INTO role (name_, user_, description_) VALUES ('salesman', 'admin', '销售');
INSERT INTO role (name_, user_, description_) VALUES ('radiologist', 'lucy', '放射科医师');
