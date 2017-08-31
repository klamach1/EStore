/*
create database estore;
grant all privileges on estore.* to estore;
*/
DROP TABLE IF EXISTS estore.product_order CASCADE;
DROP TABLE IF EXISTS estore.order CASCADE;
DROP TABLE IF EXISTS estore.catalog CASCADE;
DROP TABLE IF EXISTS estore.products CASCADE;

create table estore.catalog
(
  catalog_id        INT          NOT NULL,
  catalog_name VARCHAR(256) NOT NULL UNIQUE,
  PRIMARY KEY (catalog_id)
);

create table estore.product
(
product_id INT NOT NULL,
catalog_id int not null,
sku varchar(256) NOT NULL,
product_name varchar(256) not null,
available_quantity int not null,
uom varchar(256) not null,
PRIMARY KEY (product_id),
FOREIGN KEY (catalog_id) REFERENCES estore.catalog (catalog_id)
);



create table estore.order
(
  order_id        INT          NOT NULL AUTO_INCREMENT,
  order_created datetime NOT NULL,
  total_amount INT,
  confirm_number INT,
  user varchar(256),
  PRIMARY KEY (order_id)
);

create table estore.product_order
(
product_order_id INT NOT NULL AUTO_INCREMENT,
order_id int not null,
product_id int not null,
order_amount int not null,
PRIMARY KEY (product_order_id),
FOREIGN KEY (order_id) REFERENCES estore.order (order_id),
FOREIGN KEY (product_id) REFERENCES estore.product (product_id)
);
