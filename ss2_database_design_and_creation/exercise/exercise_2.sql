create database if not exists selling_manager;
use selling_manager;

create table customer(
  customer_id int primary key auto_increment, 
  customer_name varchar(50), 
  customer_age int
);

create table `order`(
  order_id int primary key auto_increment, 
  customer_id int, 
  order_date date, 
  order_total_price double, 
  foreign key (customer_id) references customer (customer_id)
);

create table product(
  product_id int primary key auto_increment, 
  product_name varchar(50), 
  product_price double
);

create table order_detail(
  order_id int, 
  product_id int, 
  order_detail_qty int, 
  foreign key (order_id) references `order`(order_id), 
  foreign key (product_id) references product (product_id)
);
