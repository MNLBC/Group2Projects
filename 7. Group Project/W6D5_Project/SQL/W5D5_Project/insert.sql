--User Dummy Data
INSERT INTO USERS(USERFNAME,USERLNAME,USEREMAIL,USERPASS,USERADDRESS1,USERADDRESS2,USERCITY,USERSP,USERCOUNTRY,USERTYPE) 
VALUES('GROUP2','TEST','test@test.com','abc','19-B Sta Agueda Drive','Regency Place Merville','Manila','Metro Manila','Philippines','Cutomer');

INSERT INTO USERS(USERFNAME,USERLNAME,USEREMAIL,USERPASS,USERADDRESS1,USERADDRESS2,USERCITY,USERSP,USERCOUNTRY,USERTYPE) 
VALUES('Faye','Raegan','fraegan@yp.com','abc','300 BOYLSTON','Fresno','Los Angeles','California','USA','BLACKLIST');

INSERT INTO USERS(USERFNAME,USERLNAME,USEREMAIL,USERPASS,USERADDRESS1,USERADDRESS2,USERCITY,USERSP,USERCOUNTRY,USERTYPE) 
VALUES('GROUP2','TEST','testadmin@test.com','abc','200 E MAIN ST','Fresno','Los Angeles','California','USA','Admin');
INSERT INTO ORDERS(USERID)
VALUES(1);

--OrderProduct Dummy Data
INSERT INTO ORDERPRODUCT(ORDERID,PRODID,ORDERPRODQTY) 
VALUES(1,1,2);

INSERT INTO ORDERPRODUCT(ORDERID,PRODID,ORDERPRODQTY) 
VALUES(1,2,3);

COMMIT;