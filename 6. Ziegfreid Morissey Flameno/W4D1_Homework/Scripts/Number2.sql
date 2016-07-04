/*
DQL stands for Data Query Language. It pertains to the "SELECT" Statement in PL/SQL which is used to search/query records in the table.
Commands: SELECT
Example:
*/

SELECT * FROM users WHERE first_name = 'Dummy';
SELECT * FROM orders WHERE order_date BETWEEN '01-JAN-16' AND '04-JUL-16';
SELECT order_item_name FROM order_items WHERE order_item_quantity > 1;

/*
DML stands for Data Manipulation Language. It pertains to the commands that edits/updates the records of a given table.
Commands: CALL, DELETE, EXPLAIN PLAN, INSERT, LOCK TABLE, MERGE, UPDATE
Example:
*/

INSERT INTO users VALUES ('1', 'Dummy', 'Test');
UPDATE orders SET order_date = SYSDATE WHERE order_id = '1';
DELETE FROM order_items WHERE order_item_id = '1';

/*
DDL stands for Data Definition Language. It pertains to the commands that affect the whole table itself (as opposed to DML which only affects the records).
Commands: ALTER, ANALYZE, ASSOCIATE STATISTICS, AUDIT, COMMENT, CREATE, DISASSOCIATE STATISTICS, DROP, FLASHBACK, NOAUDIT, PURGE, RENAME, TRUNCATE
Example: 
*/

DROP TABLE users;
DROP TABLE orders;
DROP TABLE order_items;

/*
DCL stands for Data Control Language. It pertains to the commands that allows the control of table access and committing/rollbacking of data (this part may be DTL - Data Transaction Language).
Commands: GRANT, REVOKE, ROLLBACK(can be DTL), COMMIT(can be DTL)
Example:
*/

GRANT DELETE, INSERT, SELECT, UPDATE ON users TO admin;
GRANT DELETE, INSERT, SELECT, UPDATE ON orders TO admin;
GRANT DELETE, INSERT, SELECT, UPDATE ON order_items TO admin;

--Note that ADMIN is a username