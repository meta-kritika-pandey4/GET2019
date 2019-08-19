-- database created and used
create database storefront;
use storefront;

-- schema of product table

create table Product (
 product_id varchar(100) Primary key,
 product_name varchar (1000),
 product_description varchar (1000),
 product_price float,
 category_id varchar(100) references Category(category_id));
 
 -- schema of user table
 
 create table User (
 user_id varchar(100) Primary key,
 user_name varchar (1000),
 password varchar (1000),
 dob date,
 gender varchar(20));
 
 -- schema of shopper table
 
 create table Shopper (
 shopper_id varchar(100) Primary key references User(user_id),
 phone_no bigint);
 
 -- schema of admin table
 
 create table Admin(
 admin_id varchar(100) Primary key references User(user_id),
 permissions varchar(1000));
 
 -- schema of ShippingAddress table
 
 create table ShippingAddress(
 shopper_id varchar(100) Primary key references Shopper(shopper_id),
 house_no int,
 block_no int,
 street varchar(1000),
 city varchar(500),
 state varchar(500),
 pincode int,
 foreign key(shopper_id) references Shopper(shopper_id));
 
 -- schema of category table
 
 create table Category(
 category_id varchar(100) Primary key,
 category_name varchar(500),
 parent_id varchar(100) default 'top category' references category(category_id));
 
 -- schema of image table
 
 create table image(
 image_id varchar(100) Primary key,
 image_name varchar(500),
 image longblob,
 product_id varchar(100),
 foreign key(product_id) references Product(product_id));
 
  -- schema of shopping_order table
 
 create table shopping_order(
 order_id varchar(100) Primary key,
 order_date timestamp default current_timestamp,
 user_id varchar(100) references Shopper(shopper_id));
 
  -- schema of stock table
  
 create table stock(
 stock_id varchar(100)  Primary key,
 product_id varchar(100) references product(product_id),
 available_quantity int);
 
  -- schema of order_item table
  
 create table order_item(
 stock_id varchar(100)  references stock(stock_id),
 order_id varchar(100)  references shopping_order(order_id),
 ordered_quantity int,
 discount float,
 order_status varchar(500));

 -- display all the table names present in StoreFront
 
 show tables;
 
--  remove Product table of the StoreFront database.

set FOREIGN_KEY_CHECKS = 0;
drop table product;

-- Create the Product table again.

create table Product (
 product_id varchar(100) Primary key,
 product_name varchar (1000),
 product_description varchar (1000),
 product_price float,
 category_id varchar(100) references Category(category_id));
 