create database student_management;
use student_management;

create table class(
id int primary key auto_increment,
`name` varchar(20)
);

create table teacher(
id int primary key auto_increment,
`name` varchar(20),
age int,
country varchar(50)
);

insert into class (id, `name`)
values (1, 'C09'),
       (2, 'C08');
       
insert into teacher(id, `name`, age, country)
values (1, 'Tài', 18, 'Việt Nam'),
	   (2, 'Nghĩa', 19, 'Campuchia');