
--For # 1
CREATE TABLE Users
(
User_Id int NOT NULL,
Name varchar(255),
PRIMARY KEY (User_Id)

);

CREATE TABLE Orders
(
Order_Id int NOT NULL,
User_Id int NOT NULL,
PRIMARY KEY (Order_Id),
CONSTRAINT fk_OrderUser FOREIGN KEY (User_Id)
REFERENCES Users(User_Id)
);

CREATE TABLE Order_Items
(
Item_Id int NOT NULL,
Item_Name varchar(255),
Order_Id int NOT NULL,
PRIMARY KEY (Item_Id),
CONSTRAINT fk_OrderItem FOREIGN KEY (Order_Id)
REFERENCES Orders(Order_Id)
);

/
--For # 2
--DQL is abbreviation of Data Query Language. Used to retrieve the records / data from database.
--SELECT - retrieve data from the a database
select * from  users;

/
--Data Definition Language (DDL) statements are used to define the database structure or schema. Some examples:
--CREATE - to create objects in the database
CREATE TABLE Users
(
User_Id int NOT NULL,
Name varchar(255),
PRIMARY KEY (User_Id)

);
/
--ALTER - alters the structure of the database
ALTER TABLE USERS
ADD ADDRESS VARCHAR(255);

/
--DROP - delete objects from the database
DROP TABLE ORDER_ITEMS;
/
--TRUNCATE - remove all records from a table, including all spaces allocated for the records are removed
TRUNCATE TABLE ORDER_ITEMS;

--Data Manipulation Language (DML) statements are used for managing data within schema objects. Some examples:

--INSERT - insert data into a table
INSERT INTO USERS VALUES(1, 'LANCE');
INSERT INTO USERS(USER_ID) VALUES(2);
--UPDATE - updates existing data within a table
UPDATE USERS SET NAME = 'JASPER' WHERE USER_ID = 2;
--DELETE - deletes all records from a table, the space for the records remain
DELETE FROM USERS WHERE USER_ID = 2;


--Data Control Language (DCL) statements. Some examples:
--GRANT - gives user's access privileges to database
CREATE ROLE Lance;
GRANT SELECT,UPDATE ON ORDERS TO Lance;
--REVOKE - withdraw access privileges given with the GRANT command
REVOKE SELECT,UPDATE ON ORDERS FROM Lance;


