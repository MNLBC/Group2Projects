DROP TABLE ORDERPRODUCT;
DROP TABLE PRODUCT;
DROP TABLE ORDERS;
DROP TABLE USERS;

CREATE TABLE USERS(
  USERID        NUMBER(3)     NOT NULL      PRIMARY KEY,
  USERFNAME         VARCHAR2(50),
  USERLNAME         VARCHAR2(50),
  USEREMAIL         VARCHAR2(50),
  USERPASS		    VARCHAR2(50),
  USERSTREET        VARCHAR2(100),
  USERCITY          VARCHAR2(50),
  USERCOUNTRY       VARCHAR2(50),
  USERTYPE          VARCHAR2(10)
);

CREATE TABLE PRODUCT(
  PRODID        NUMBER(3)     NOT NULL      PRIMARY KEY,
  PRODNAME      VARCHAR2(50),
  PRODCATEGORY      VARCHAR2(50),
  PRODDESC			VARCHAR(50),
  PRODPRICE         NUMBER(9,2),
  PRODSALE			NUMBER(3,2),
  PRODSTOCK         NUMBER(4),
  PRODIMG           VARCHAR2(50)
);

CREATE TABLE ORDERS(
  ORDERID       NUMBER(3)     NOT NULL      PRIMARY KEY,
  USERID        NUMBER(3),
  ORDERTOTAL         NUMBER(9,2),
  ORDERDATE      VARCHAR2(50),
  CONSTRAINT fk_user FOREIGN KEY (USERID) REFERENCES USERS(USERID)
);

CREATE TABLE ORDERPRODUCT(
  ORDERPRODID  NUMBER(3)     NOT NULL      PRIMARY KEY,
  ORDERID         NUMBER(3),
  PRODID          NUMBER(3),
  ORDERPRODQTY             NUMBER(4),
  CONSTRAINT fk_order FOREIGN KEY (ORDERID) REFERENCES ORDERS(ORDERID),
  CONSTRAINT fk_prod FOREIGN KEY (PRODID) REFERENCES PRODUCT(PRODID)
);


--CREATE SEQUENCE
CREATE SEQUENCE  "GROUP2"."USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

--CREATE USER
CREATE USER GROUP2 IDENTIFIED BY GROUP2;
GRANT CONNECT, RESOURCE TO GROUP2;