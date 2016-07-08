
-- -----------------------------------------------------
-- Schema W4D4DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema W4D4DB
-- -----------------------------------------------------
CREATE USER W4D4DB IDENTIFIED BY W4D4DB /* DEFAULT CHARACTER SET utf8 */ /* COLLATE utf8_general_ci */ ;
ALTER SESSION SET CURRENT_SCHEMA = W4D4DB ;

-- -----------------------------------------------------
-- Table `W4D4DB`.`User`
-- -----------------------------------------------------
CREATE TABLE W4D4DB.User (
  userId NUMBER(10) NOT NULL,
  userFname VARCHAR2(25) NOT NULL,
  userLname VARCHAR2(25) NOT NULL,
  userEmail VARCHAR2(50) NOT NULL,
  userStreet VARCHAR2(25) NOT NULL,
  userCity VARCHAR2(25) NOT NULL,
  userCountry VARCHAR2(25) NOT NULL,
  userPass VARCHAR2(15) NOT NULL,
  userType VARCHAR2(12) NOT NULL,
  PRIMARY KEY (userId))
;

-- Generate ID using sequence and trigger
CREATE SEQUENCE W4D4DB.User_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER W4D4DB.User_seq_tr
 BEFORE INSERT ON W4D4DB.User FOR EACH ROW
 WHEN (NEW.userId IS NULL)
BEGIN
 SELECT W4D4DB.User_seq.NEXTVAL INTO :NEW.userId FROM DUAL;
END;
/


-- -----------------------------------------------------
-- Table `W4D4DB`.`Product`
-- -----------------------------------------------------
CREATE TABLE W4D4DB.Product (
  prodId NUMBER(10) NOT NULL,
  prodName VARCHAR2(25) NOT NULL,
  prodDesc VARCHAR2(45) NULL,
  prodCat VARCHAR2(25) NOT NULL,
  prodImg VARCHAR2(45) NOT NULL,
  prodPrice NUMBER(9,2) NOT NULL,
  prodSale NUMBER(1,2) DEFAULT 1 NOT NULL,
  prodStock NUMBER(10) NOT NULL,
  PRIMARY KEY (prodId))
;

-- Generate ID using sequence and trigger
CREATE SEQUENCE W4D4DB.Product_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER W4D4DB.Product_seq_tr
 BEFORE INSERT ON W4D4DB.Product FOR EACH ROW
 WHEN (NEW.prodId IS NULL)
BEGIN
 SELECT W4D4DB.Product_seq.NEXTVAL INTO :NEW.prodId FROM DUAL;
END;
/


-- -----------------------------------------------------
-- Table `W4D4DB`.`Order`
-- -----------------------------------------------------
CREATE TABLE W4D4DB.Order (
  orderId NUMBER(10) NOT NULL,
  userId NUMBER(10) NOT NULL,
  orderTotal NUMBER(9,2) NOT NULL,
  orderDate VARCHAR2(20) NOT NULL,
  PRIMARY KEY (orderId)
 ,
  CONSTRAINT userId
    FOREIGN KEY (userId)
    REFERENCES W4D4DB.User (userId)
   )
;

-- Generate ID using sequence and trigger
CREATE SEQUENCE W4D4DB.Order_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER W4D4DB.Order_seq_tr
 BEFORE INSERT ON W4D4DB.Order FOR EACH ROW
 WHEN (NEW.orderId IS NULL)
BEGIN
 SELECT W4D4DB.Order_seq.NEXTVAL INTO :NEW.orderId FROM DUAL;
END;
/

CREATE INDEX userId_idx ON W4D4DB.Order (userId ASC);


-- -----------------------------------------------------
-- Table `W4D4DB`.`OrderProduct`
-- -----------------------------------------------------
CREATE TABLE W4D4DB.OrderProduct (
  orderProdId NUMBER(10) NOT NULL,
  orderId NUMBER(10) NOT NULL,
  prodId NUMBER(10) NOT NULL,
  orderProdQty NUMBER(10) NOT NULL,
  PRIMARY KEY (orderProdId)
 ,
  CONSTRAINT orderId
    FOREIGN KEY (orderId)
    REFERENCES W4D4DB.Order (orderId)
   ,
  CONSTRAINT productId
    FOREIGN KEY (prodId)
    REFERENCES W4D4DB.Product (prodId)
   )
;

-- Generate ID using sequence and trigger
CREATE SEQUENCE W4D4DB.OrderProduct_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER W4D4DB.OrderProduct_seq_tr
 BEFORE INSERT ON W4D4DB.OrderProduct FOR EACH ROW
 WHEN (NEW.orderProdId IS NULL)
BEGIN
 SELECT W4D4DB.OrderProduct_seq.NEXTVAL INTO :NEW.orderProdId FROM DUAL;
END;
/

CREATE INDEX orderId_idx ON W4D4DB.OrderProduct (orderId ASC);
CREATE INDEX productId_idx ON W4D4DB.OrderProduct (prodId ASC);


/* SET SQL_MODE=@OLD_SQL_MODE; */
/* SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS; */
/* SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS; */

