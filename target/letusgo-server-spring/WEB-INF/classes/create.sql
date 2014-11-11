CREATE user'rest'@'localhost' IDENTIFIED BY 'letusgo';

DROP DATABASE IF EXISTS letusgo;
CREATE DATABASE letusgo;

GRANT ALL ON letusgo.* TO 'rest'@'localhost';

USE letusgo;

CREATE TABLE categories(
  c_id INT PRIMARY KEY AUTO_INCREMENT,
  c_name VARCHAR(40) NOT NULL
);

INSERT categories VALUES(null,'服装鞋包'),(null,'全球美食'),(null,'日常用品');

CREATE TABLE items(
  i_id INT PRIMARY KEY AUTO_INCREMENT,
  i_barcode VARCHAR(30),
  i_name VARCHAR(30),
  i_unit VARCHAR(8),
  i_price DOUBLE,
  i_categoryid int not null,
  CONSTRAINT category_item_fk FOREIGN KEY(i_categoryid) REFERENCES categories(c_id)
);

INSERT items VALUES
  (null,'ITEM000001','女装','套',1000,1),
  (null,'ITEM000002','手提包','个',200,1),
  (null,'ITEM000003','五花肉','斤',30.5,2),
  (null,'ITEM000004','羊肉泡馍','碗',15,2),
  (null,'ITEM000005','拖把','个',30,3),
  (null,'ITEM000006','鞋架','个',100,3);

CREATE TABLE cart_items(
  c_id INT PRIMARY KEY AUTO_INCREMENT,
  c_barcode VARCHAR(30),
  c_count DOUBLE
);