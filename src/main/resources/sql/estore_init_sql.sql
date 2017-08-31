/*
create database estore;
grant all privileges on estore.* to estore;
*/

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
