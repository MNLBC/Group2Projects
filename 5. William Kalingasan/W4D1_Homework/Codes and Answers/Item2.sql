--DQL (Data Query Language) is used for reading data in a database. (Using SELECT)
--DML (Data Manipulation Language) is used for creating,updating or deleting records of data in a database (USING INSERT,UPDATE,DELETE)
--DDL (Data Definition Language) is used for metadata. Allows to add, modify or delete logical structures in a database (USING CREATE, ALTER, DROP)
--DCL (Data Control Language) is used to grant or revoke permissions in the database. Also makes a change permanent or rolls it back (USING GRANT,REVOKE,ROLLBACK,COMMIT)

--DQL (SELECT)
SELECT * FROM USER_TABLE;
SELECT ORDER_DESC,USERNAME FROM ORDER_TABLE ORDER BY ORDER_DT;
SELECT
  A.FULL_NAME,
  C.ITEM_DESC
FROM
  USER_TABLE A, ORDER_TABLE B, ORDERITEM_TABLE C
WHERE A.USERNAME = B.USERNAME
AND B.ORDER_ID = C.ORDER_ID;

--DML (INSERT) DQL(COMMIT)
INSERT INTO USER_TABLE(USERNAME,PASSWORD,FULL_NAME) VALUES('williuum','august22','William Kalingasan');
INSERT INTO USER_TABLE(USERNAME,PASSWORD,FULL_NAME) VALUES('paulyndimapilis','june22','Jana Dimapilis');
INSERT INTO USER_TABLE(USERNAME,PASSWORD,FULL_NAME) VALUES('xander','september13','Xander Sarmiento');
INSERT INTO USER_TABLE(USERNAME,PASSWORD,FULL_NAME) VALUES('ranie','may24','Ranie Santiago');
INSERT INTO USER_TABLE(USERNAME,PASSWORD,FULL_NAME) VALUES('paolo','april20','Paolo Talento');
INSERT INTO ORDER_TABLE(ORDER_ID,ORDER_DESC,ORDER_DT,USERNAME) VALUES('1','Sample Description 1','22-AUG-96','williuum');
INSERT INTO ORDER_TABLE(ORDER_ID,ORDER_DESC,ORDER_DT,USERNAME) VALUES('2','Sample Description 2','22-JUN-93','paulyndimapilis');
INSERT INTO ORDER_TABLE(ORDER_ID,ORDER_DESC,ORDER_DT,USERNAME) VALUES('3','Dummy Data','13-SEP-95','williuum');
INSERT INTO ORDER_TABLE(ORDER_ID,ORDER_DESC,ORDER_DT,USERNAME) VALUES('4','Dummy Data','24-MAY-96','paulyndimapilis');
INSERT INTO ORDER_TABLE(ORDER_ID,ORDER_DESC,ORDER_DT,USERNAME) VALUES('5','Dummy Data','20-APR-95','williuum');
INSERT INTO ORDERITEM_TABLE(ORDERITEM_ID,ORDER_ID,ITEM_DESC) VALUES('1','1','Apple');
INSERT INTO ORDERITEM_TABLE(ORDERITEM_ID,ORDER_ID,ITEM_DESC) VALUES('2','1','Pork');
INSERT INTO ORDERITEM_TABLE(ORDERITEM_ID,ORDER_ID,ITEM_DESC) VALUES('3','1','Banana');
INSERT INTO ORDERITEM_TABLE(ORDERITEM_ID,ORDER_ID,ITEM_DESC) VALUES('4','2','Ramen');
INSERT INTO ORDERITEM_TABLE(ORDERITEM_ID,ORDER_ID,ITEM_DESC) VALUES('5','2','Burger');
COMMIT;

--DML (UPDATE) DQL(COMMIT)
UPDATE USER_TABLE SET PASSWORD = 'june22' WHERE USERNAME = 'williuum';
UPDATE ORDER_TABLE SET ORDER_DESC = 'Test Data' WHERE ORDER_ID > 2;
UPDATE ORDERITEM_TABLE SET ITEM_DESC = 'Pizza' WHERE ORDERITEM_ID = 3;
COMMIT;

--DML (DELETE) DQL(COMMIT)
DELETE FROM USER_TABLE WHERE PASSWORD LIKE 'ma%';
DELETE FROM ORDER_TABLE WHERE ORDER_ID > 2;
DELETE FROM ORDERITEM_TABLE;
COMMIT;

--DDL (CREATE)
CREATE TABLE USER_TABLE(
  USERNAME      VARCHAR2(50)      NOT NULL      PRIMARY KEY,
  PASSWORD      VARCHAR2(50)      NOT NULL,
  FULL_NAME     VARCHAR2(50)
);

CREATE TABLE ORDER_TABLE(
  ORDER_ID      NUMBER(3)       NOT NULL      PRIMARY KEY,
  ORDER_DESC    VARCHAR2(100),
  ORDER_DT      DATE,
  USERNAME    VARCHAR2(50),
  CONSTRAINT fk_user FOREIGN KEY (USERNAME) REFERENCES USER_TABLE(USERNAME)
);

CREATE TABLE ORDERITEM_TABLE(
  ORDERITEM_ID  NUMBER(3)       NOT NULL      PRIMARY KEY,
  ORDER_ID      NUMBER(3),
  ITEM_DESC     VARCHAR2(100),
  CONSTRAINT fk_order FOREIGN KEY (ORDER_ID) REFERENCES ORDER_TABLE(ORDER_ID)
);

--DDL (ALTER)
ALTER TABLE USER_TABLE ADD GENDER CHAR(1);
ALTER TABLE ORDER_TABLE RENAME COLUMN USERNAME TO ORDER_USERNAME;
ALTER TABLE ORDERITEM_TABLE ADD SAMPLECOLUMN VARCHAR2(10);
ALTER TABLE ORDERITEM_TABLE DROP COLUMN SAMPLECOLUMN;

--DDL (DROP)
DROP TABLE USER_TABLE;
DROP TABLE ORDERITEM_TABLE;
DROP TABLE ORDER_TABLE;


--DCL(ROLLBACK)
INSERT INTO USER_TABLE(USERNAME,PASSWORD,FULL_NAME) VALUES('ranie','may24','Ranie Santiago');
INSERT INTO ORDER_TABLE(ORDER_ID,ORDER_DESC,ORDER_DT,USERNAME) VALUES('10','Sample Description 1','22-AUG-96','williuum');
INSERT INTO ORDERITEM_TABLE(ORDERITEM_ID,ORDER_ID,ITEM_DESC) VALUES('50','2','Burger');
ROLLBACK;

--DCL(GRANT)
--Please create TESTACCT user before running these statements
/*
CREATE USER testacct IDENTIFIED BY abc;
GRANT CONNECT, RESOURCE TO testacct;
*/
GRANT SELECT,UPDATE,INSERT, DELETE ON USER_TABLE TO TESTACCT;
GRANT SELECT,UPDATE,INSERT, DELETE ON ORDER_TABLE TO TESTACCT;
GRANT SELECT,UPDATE,INSERT, DELETE ON ORDERITEM_TABLE TO TESTACCT;

--DCL(REVOKE)
REVOKE ALL ON USER_TABLE FROM TESTACCT;
REVOKE ALL ON ORDER_TABLE FROM TESTACCT;
REVOKE ALL ON ORDERITEM_TABLE FROM TESTACCT;