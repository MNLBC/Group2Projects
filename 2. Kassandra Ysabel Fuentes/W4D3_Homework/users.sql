CREATE TABLE USERS (
   id VARCHAR(10) NOT NULL,
   first_name VARCHAR(25) NOT NULL,
   last_name VARCHAR(25) NOT NULL,
   address VARCHAR(45) NULL,
   email VARCHAR(15) NOT NULL,
   password VARCHAR(12) NOT NULL,
  CONSTRAINTS USERS_PK PRIMARY KEY(id));