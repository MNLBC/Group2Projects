CREATE TABLE item (
  item_id VARCHAR(100) NOT NULL PRIMARY KEY,
  item_name VARCHAR(100),
  item_category VARCHAR(100),
  item_stock INTEGER,
  item_price INTEGER)
;

INSERT INTO ITEM(item_id, item_name, item_category, item_stock, item_price) VALUES('322', 'Item Name 001', 'Item Category 001', 322, 223);
INSERT INTO ITEM(item_id, item_name, item_category, item_stock, item_price) VALUES('223', 'Item Name 002', 'Item Category 002', 223, 322);
INSERT INTO ITEM(item_id, item_name, item_category, item_stock, item_price) VALUES('022', 'Item Name 003', 'Item Category 003', 003, 022);