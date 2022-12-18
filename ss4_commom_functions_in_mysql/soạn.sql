create database soan_bai;
use soan_bai;
create table student(
student_id int primary key auto_increment,
name varchar(50),
gender bit(1),
birthday varchar(50),
email varchar(50),
point double,
username varchar(50),
class_id int,
foreign key (class_id) references class(class_id)
);

create table class(
class_id int primary key auto_increment,
name varchar(50)
);

create table instructor(
instructor_id int primary key auto_increment,
name varchar(50),
birthday varchar(50),
salary double
);

create table instructor_class(
instructor_id int,
foreign key (instructor_id) references instructor(instructor_id),
class_id int,
foreign key (class_id) references class(class_id),
start_time varchar(50)
);

insert into student (student_id, name, gender, birthday, email, point, username, class_id)
values (1, 'nguyen ngoc cu', 1, '1981/12/12', null, 8, 'cunn', 1),
 (2, 'le hai chung', 1, '1981/12/12', null, 5, 'chunglh', 1),
 (3, 'hoang huu hoan', 1, '1981/12/12', null, 6, 'hoanghh', 2),
 (4, 'dau dung', 1, '1981/12/12', null, 8, 'dungd', 1),
 (5, 'ta dinh huynh', 1, '1981/12/12', null, 7, 'huynhtd', 2),
 (6, 'nguyen minh hai', 1, '1981/12/12', null, 10, 'hainm', 1),
 (7, 'tran van nam', 1, '1981/12/12', null, 4, 'namtv', 2),
 (8, 'vo minh hieu', 1, '1981/12/12', null, 3, 'hieuvm', 1),
 (9, 'le xuan ky', 1, '1981/12/12', null, 7, 'kynx', 2),
 (10, 'le minh vu', 1, '1981/12/12', null, 7, 'vuln', 1),
 (15, 'nguyen van a', 1, '1981/12/12', null, 8, null, null),
 (16, 'tran van b', 1, '1981/12/12', null, 5, null, null);
 
 insert into class(class_id, name)
 values(1, 'c1121g1'),
 (2, 'c1221g1'),
 (3, 'c0821i1'),
 (4, 'c0921i1');
 
 insert into instructor(instructor_id, name, birthday, salary)
 values (1, 'tran van chanh', '1985/3/2', 100),
  (2, 'tran minh chien', '1985/3/2', 200),
  (3, 'vu van tien', '1985/3/2', 300),
  (4, 'tran van nam', '1989/12/12', 100);
  
  insert into instructor_class(instructor_id, class_id, start_time)
  values(1,1, null),
  (1,2, null),
  (1,3, null),
  (2,1, null),
  (2,2, null),
  (2,3, null);

 -- 1.Hiện thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp 
select c.name, count(s.student_id) 
from class c
join student s on s.class_id = c.class_id
group by c.class_id;

-- 2.Tính điểm lớn nhất của mỗi các lớp
select c.name, max(s.point) as max_point
from class c
join student s on s.class_id = c.class_id
group by c.class_id;

-- 3.Tình điểm trung bình  của từng lớp
select c.name, avg(s.point)
from class c
join student s on s.class_id = c.class_id
group by c.class_id;

-- 4.Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym
select name, birthday 
from instructor;

-- 5.Lấy ra top 3 học viên có điểm cao nhất của trung tâm
-- select * from student 
-- group by student_id
-- having max(point)
-- limit 3;

-- (select max(point) from student group by student_id )limit 3;
-- 6.Lấy ra các học viên có điểm số là cao nhất của trung tâm.
select * from student 
where point in
(select max(point) from student);

