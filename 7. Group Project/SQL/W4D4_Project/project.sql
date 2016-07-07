CREATE TABLE USERS(
  USERID        NUMBER(3)     NOT NULL      PRIMARY KEY,
  FNAME         VARCHAR2(50),
  LNAME         VARCHAR2(50),
  EMAIL         VARCHAR2(50),
  PASSWORD      VARCHAR2(50),
  STREET        VARCHAR2(100),
  CITY          VARCHAR2(50),
  COUNTRY       VARCHAR2(50),
  TYPE          VARCHAR2(10),
  ACTIVE        NUMBER(1)
);

CREATE TABLE PRODUCT(
  PRODID        NUMBER(3)     NOT NULL      PRIMARY KEY,
  PRODNAME      VARCHAR2(50),
  CATEGORY      VARCHAR2(50),
  PRICE         NUMBER(9,2),
  STOCK         NUMBER(4),
  IMG           VARCHAR2(50)
);

CREATE TABLE ORDERS(
  ORDERID       NUMBER(3)     NOT NULL      PRIMARY KEY,
  USERID        NUMBER(3),
  TOTAL         NUMBER(9,2),
  ORDER_DT      DATE,
  CONSTRAINT fk_user FOREIGN KEY (USERID) REFERENCES USERS(USERID)
);

CREATE TABLE ORDERPRODUCT(
  ORDERPRODUCTID  NUMBER(3)     NOT NULL      PRIMARY KEY,
  ORDERID         NUMBER(3),
  PRODID          NUMBER(3),
  QTY             NUMBER(4),
  CONSTRAINT fk_order FOREIGN KEY (ORDERID) REFERENCES ORDERS(ORDERID),
  CONSTRAINT fk_prod FOREIGN KEY (PRODID) REFERENCES PRODUCT(PRODID)
);


--CREATE SEQUENCE
CREATE SEQUENCE  "GROUP2"."USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

--CREATE USER
CREATE USER GROUP2 IDENTIFIED BY GROUP2;
GRANT CONNECT, RESOURCE TO GROUP2;