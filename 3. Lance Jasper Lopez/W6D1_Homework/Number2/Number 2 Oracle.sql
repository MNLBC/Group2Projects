

CREATE TABLE H_User (
  userid NUMBER(10) NOT NULL,
  name VARCHAR2(100) NULL,
  address VARCHAR2(100) NULL,
  PRIMARY KEY (userid))
;




CREATE TABLE H_Order (
  orderid NUMBER(10) NOT NULL,
  User_userid NUMBER(10) NOT NULL,
  dateoforder VARCHAR2(100) NULL,
  PRIMARY KEY (orderid, User_userid)
 ,
  CONSTRAINT fk_Order_User
    FOREIGN KEY (User_userid)
    REFERENCES H_User (userid)
   )
;

CREATE TABLE H_OrderItem (
  OrderItemId NUMBER(10) NOT NULL,
  Order_orderid NUMBER(10) NOT NULL,
  Order_User_userid NUMBER(10) NOT NULL,
  productid VARCHAR2(45) NULL,
  PRIMARY KEY (OrderItemId, Order_orderid, Order_User_userid)
 ,
  CONSTRAINT fk_OrderItem_Order1
    FOREIGN KEY (Order_orderid , Order_User_userid)
    REFERENCES H_Order (orderid , User_userid)
   )
;



