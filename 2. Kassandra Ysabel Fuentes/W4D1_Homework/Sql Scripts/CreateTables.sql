     CREATE TABLE ORDERITEM
   (ORDERITEM_ID INT NOT NULL, 
	ORDERITEM_CUSTOMER INT NOT NULL, 
	ORDERITEM_NAME VARCHAR2(20) NOT NULL, 
	ORDERITEM_PRICE DECIMAL(8,2) NOT NULL, 
	ORDERITEM_DESCRIPTION VARCHAR2(25) NOT NULL, 
	ORDERITEM_QUANTITY NUMBER(2) NOT NULL, 
	CONSTRAINT ORDERITEM_PK PRIMARY KEY(ORDERITEM_ID)
   );   

  
  CREATE TABLE USERS
   (USERS_ID INT NOT NULL, 
    USERS_ORDERS INT NOT NULL, 
	USERS_FNAME VARCHAR2(20) NOT NULL, 
	USERS_LNAME VARCHAR2(20) NOT NULL, 
	USERS_CONTACT VARCHAR2(20), 
	USERS_ADDRESS VARCHAR2(20) NOT NULL, 
	CONSTRAINT USERS_PK PRIMARY KEY(USERS_ID),
	CONSTRAINT FK_USERS FOREIGN KEY (USERS_ORDERS) REFERENCES ORDERITEM(ORDERITEM_ID)
   );
   
   
    CREATE TABLE ORDERS
   (ORDERS_ID INT NOT NULL, 
	ORDERS_USERS INT NOT NULL, 
    ORDERS_ITEMORDER INT NOT NULL,
    ORDERS_NUMBER INT NOT NULL,
	ORDERS_TOTAL DECIMAL(8,2) NOT NULL,  
	CONSTRAINT ORDERS_PK PRIMARY KEY(ORDERS_ID),
	CONSTRAINT FK_ORDERSUSERS FOREIGN KEY (ORDERS_USERS) REFERENCES USERS(USERS_ID),
    CONSTRAINT FK_ORDERSITEMS FOREIGN KEY (ORDERS_ITEMORDER) REFERENCES ORDERITEM(ORDERITEM_ID)
   );
   