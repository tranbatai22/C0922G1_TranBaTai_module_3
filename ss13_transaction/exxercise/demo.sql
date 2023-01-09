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
insert into users(name, email, country) values('nghĩa','abc@che.uk','dn');

select * from users;

delete from users where id = 1;
insert into users(`name`, email, country) values(?, ?, ?);
update users set name = ?,email= ?, country =? where id = ?;
select id,name,email,country from users where id =?;
select * from users where country like ?;


delimiter //
create procedure select_all_user()
begin 
select * from users;
end //
delimiter ;

call select_all_user;


delimiter //
create procedure update_user (name1 varchar(50), email1 varchar(50), country1 varchar(50), id1 int)
begin 
update users set name = name1, email= email1, country = country1 where id = id1;
end //
delimiter ;

set SQL_SAFE_UPDATES = 0;
call update_user("định", "dinh123@gmail.com", "dn", 3);

delimiter //
create procedure delete_user (id1 int)
begin 
delete from users where id = id1;
end //
delimiter ;

call delete_user(3);
