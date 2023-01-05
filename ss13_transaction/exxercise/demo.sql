
CREATE DATABASE demo;
USE demo;

create table users (
 id int primary key AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('tài','kante@che.uk','Kenia');
select * from users;
delete from users where id = 1;