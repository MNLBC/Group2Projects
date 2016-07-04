--DQL (SELECT)
SELECT * FROM Orders;
SELECT user_lastname, user_firstname, user_address FROM Users WHERE user_gender = 'female';
SELECT orderitem_name, orderitem_price, orderitem_quantity FROM Orderitem WHERE orderitem_price > 70.00 ORDER BY ORDERITEM_PRICE DESC;


--DML (INSERT)
INSERT INTO Users VALUES(1, 'Meynard', 'Denoyo', 'Paranaque City', '01-JAN-96', 'male');
INSERT INTO Users VALUES(2, 'Danna', 'Soquiat', 'Makati City', '12-SEP-95', 'female');
INSERT INTO Users VALUES(3, 'Mark Anthony', 'Andes', 'Makati City', '23-SEP-95', 'male');
INSERT INTO Users VALUES(4, 'Jerica', 'Flores', 'Makati City', '27-APR-95', 'female');
INSERT INTO Users VALUES(5, 'Alexis', 'Cuntapay', 'Paranaque City', '30-JUL-96', 'male');
INSERT INTO Orderitem VALUES(1, 'Shampoo', 'For your hair', 'Personal Hygiene', 127.99, 10);
INSERT INTO Orderitem VALUES(2, 'Hair Dryer', 'For drying your hair', 'Personal Hygiene', 359.00, 20);
INSERT INTO Orderitem VALUES(3, 'Siomai', 'Delicious siomai made with pork', 'Food', 25.00, 30);
INSERT INTO Orderitem VALUES(4, 'Coke', 'Drink if you are thirsty', 'Food', 33.50, 40);
INSERT INTO Orderitem VALUES(5, 'Hammer', 'For pounding nails', 'Tools', 74.99, 5);
INSERT INTO Orders VALUES(1, '01-JAN-15', 4, 1, 3);
INSERT INTO Orders VALUES(2, '24-JUL-15', 3, 1, 4);
INSERT INTO Orders VALUES(3, '06-SEP-15', 1, 3, 5);
INSERT INTO Orders VALUES(4, '09-MAR-15', 7, 4, 1);
INSERT INTO Orders VALUES(5, '16-JUN-15', 5, 4, 2);

--DML (UPDATE)
UPDATE Users SET user_lastname = 'Zuckerberg' WHERE user_firstname = 'Meynard';
UPDATE Orderitem SET orderitem_name = 'Hair Products' WHERE orderitem_category = 'Personal Hygiene';
UPDATE Orders SET order_date = '25-DEC-15' WHERE order_id IN (1, 3);

--DML (DELETE)
DELETE FROM Orders WHERE user_id = '4';
DELETE FROM Users WHERE user_lastname LIKE 'Flo%';
DELETE FROM Orderitem WHERE orderitem_desc LIKE '%hair%';


--DDL (CREATE)
CREATE TABLE Users
(
user_id int NOT NULL,
user_firstname varchar(255) NOT NULL,
user_lastname varchar(255) NOT NULL,
user_address varchar(255) NOT NULL,
user_birthday varchar(255) NOT NULL,
user_gender varchar(255) NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE Orderitem
(
orderitem_id int NOT NULL,
orderitem_name varchar(255) NOT NULL,
orderitem_desc varchar(255) NOT NULL,
orderitem_category varchar(255) NOT NULL,
orderitem_price float NOT NULL,
orderitem_quantity int NOT NULL,
PRIMARY KEY (orderitem_id)
);

CREATE TABLE Orders
(
order_id int NOT NULL,
order_date date NOT NULL,
order_quantity int NOT NULL,
user_id int NOT NULL,
orderitem_id int NOT NULL,
PRIMARY KEY (order_id),
FOREIGN KEY (user_id) REFERENCES Users (user_id),
FOREIGN KEY (orderitem_id) REFERENCES Orderitem (orderitem_id)
);

--DDL (ALTER)
ALTER TABLE Orderitem RENAME COLUMN orderitem_quantity TO orderitem_stock;
ALTER TABLE Users ADD user_email varchar(255);
ALTER TABLE Orders DROP COLUMN order_date;

--DDL (DROP)
DROP TABLE Orders;
DROP TABLE Users;
DROP TABLE Orderitem;


--DCL (GRANT)
CREATE USER tutor IDENTIFIED BY oracle;
GRANT CONNECT, RESOURCE TO tutor;

--DCL (COMMIT)
COMMIT;

--DCL (ROLLBACK)
ROLLBACK;
