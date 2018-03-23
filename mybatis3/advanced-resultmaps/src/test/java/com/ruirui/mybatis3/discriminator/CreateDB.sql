DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS salesman;
DROP TABLE IF EXISTS customer;


CREATE TABLE person (
  id_ INT NOT NULL ,
  name_ VARCHAR(20) NOT NULL ,
  type_ VARCHAR(10) NOT NULL ,
  CONSTRAINT pk_person PRIMARY KEY (id_)
);

CREATE TABLE salesman_customer (
  salesman_id_ INT NOT NULL ,
  customer_id_  INT NOT NULL ,
  CONSTRAINT pk_salesman PRIMARY KEY (salesman_id_, customer_id_),
  CONSTRAINT uk_salesman UNIQUE (customer_id_)
);

INSERT INTO person (id_, name_, type_) VALUES (1, 'salesman1', 'SALE');
INSERT INTO person (id_, name_, type_) VALUES (2, 'salesman2', 'SALE');
INSERT INTO person (id_, name_, type_) VALUES (3, 'customer1', 'CUSTOMER');
INSERT INTO person (id_, name_, type_) VALUES (4, 'customer2', 'CUSTOMER');

INSERT INTO salesman_customer (salesman_id_, customer_id_) VALUES (1, 3);
INSERT INTO salesman_customer (salesman_id_, customer_id_) VALUES (1, 4);



