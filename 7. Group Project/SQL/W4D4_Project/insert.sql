INSERT INTO USERS(USERFNAME,USERLNAME,USEREMAIL,USERPASS,USERSTREET,USERCITY,USERCOUNTRY,USERTYPE) 
VALUES('GROUP2','TEST','test@test.com','abc','Dolores','Manila','Philippines','Cutomer');

INSERT INTO USERS(USERFNAME,USERLNAME,USEREMAIL,USERPASS,USERSTREET,USERCITY,USERCOUNTRY,USERTYPE) 
VALUES('Faye','Raegan','fraegan@yp.com','abc','Fresno','Los Angeles','USA','BLACKLIST');

INSERT INTO USERS(USERFNAME,USERLNAME,USEREMAIL,USERPASS,USERSTREET,USERCITY,USERCOUNTRY,USERTYPE) 
VALUES('GROUP2','TEST','testadmin@test.com','abc','Fresno','Los Angeles','USA','Admin');

INSERT INTO PRODUCT(PRODNAME,PRODCAT,PRODDESC,PRODPRICE,PRODSALE,PRODSTOCK,PRODIMG) 
VALUES('Watch A','Casual','Sample Watch',75000,1,100,'A');

INSERT INTO PRODUCT(PRODNAME,PRODCAT,PRODDESC,PRODPRICE,PRODSALE,PRODSTOCK,PRODIMG) 
VALUES('Watch B','Casual','Sample Watch',75000,0.75,10,'A');

INSERT INTO PRODUCT(PRODNAME,PRODCAT,PRODDESC,PRODPRICE,PRODSALE,PRODSTOCK,PRODIMG) 
VALUES('Watch C','Dress','Sample Watch',50000,1,100,'A');

INSERT INTO ORDERS(USERID)
VALUES(1);

INSERT INTO ORDERPRODUCT(ORDERID,PRODID,ORDERPRODQTY) 
VALUES(1,1,2);

INSERT INTO ORDERPRODUCT(ORDERID,PRODID,ORDERPRODQTY) 
VALUES(1,2,3);

COMMIT;