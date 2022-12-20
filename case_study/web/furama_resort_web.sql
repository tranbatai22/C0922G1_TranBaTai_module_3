create database furama_resort_web;
use furama_resort_web;

create table `position`(
position_id int primary key auto_increment,
position_name varchar(50)
);

create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(50)
);

create table division(
division_id int primary key auto_increment,
division_name varchar(50)
);

create table `user`(
user_name varchar(255) primary key,
`password` varchar(255)
);

create table role(
role_id int primary key auto_increment,
role_name varchar(50)
);

create table user_role(
role_id int,
user_name varchar(255),
foreign key (role_id) references `role` (role_id),
foreign key (user_name) references `user` (user_name)
);

create table employee(
employee_id int primary key auto_increment,
employee_name varchar(50),
employee_date_of_birthday date,
employee_id_card varchar(50),
employee_salary double,
employee_phone_number varchar(50),
employee_email varchar(50),
employee_address varchar(50),
position_id int,
education_degree_id int,
division_id int,
user_name varchar(255),
foreign key (position_id) references `position` (position_id),
foreign key (education_degree_id) references education_degree (education_degree_id),
foreign key (division_id) references division (division_id),
foreign key (user_name) references `user` (user_name)
);

create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(50)
);

create table customer(
customer_id int primary key auto_increment,
customer_name varchar(50),
date_of_birthday date,
id_card varchar(50),
gender bit(1),
phone_number varchar(50),
email varchar(50),
address varchar(50),
customer_type_id int,
foreign key (customer_type_id) references customer_type (customer_type_id)
);

create table facility_type(
facility_type_id int primary key auto_increment,
facility_type_name varchar(50)
);

create table rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(50)
);

create table facility(
facility_id int primary key auto_increment,
facility_name varchar(50),
area int,
cost double,
max_people int,
standard_room varchar(50),
description_other_convenience varchar(50),
pool_area double,
number_of_floors int,
facility_free text,
rent_type_id int,
facility_type_id int,
foreign key (rent_type_id) references rent_type (rent_type_id),
foreign key (facility_type_id) references facility_type (facility_type_id)
);

create table attach_facility(
attach_facility_id int primary key auto_increment,
attach_facility_name varchar(50),
cost double,
unit varchar(50),
`status` varchar(50)
);

create table contract(
contract_id int primary key auto_increment,
start_date datetime,
end_date datetime,
deposit double,
facility_id int,
employee_id int,
customer_id int,
foreign key (facility_id) references facility (facility_id),
foreign key (employee_id) references employee (employee_id),
foreign key (customer_id) references customer (customer_id)
);

create table contract_detail(
contract_detail_id int primary key auto_increment,
quantily int,
contract_id int,
attach_facility_id int,
foreign key (contract_id) references contract (contract_id),
foreign key (attach_facility_id) references attach_facility (attach_facility_id)
);

