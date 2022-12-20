create database demo;
use demo;

create table product(
  product_id int primary key auto_increment, 
  product_code varchar(50), 
  product_name varchar(50), 
  product_price double, 
  product_amount int, 
  product_description varchar(50), 
  product_status varchar(50)
);

insert into product (
  product_id, product_code, product_name, 
  product_price, product_amount, product_description, 
  product_status
) 
values 
  (
    1, 'dt001', 'nokia 1280', 5000, 3, 'ngon', 
    'tốt'
  ), 
  (
    2, 'dt002', 'samsung galaxy note 9', 
    7000, 5, 'ngon', 'tốt'
  ), 
  (
    3, 'dt003', 'iphone 14 promax', 9000, 
    7, 'ngon', 'tốt'
  );
  
--  Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index i_product_code on product(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index i_composite on product(product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain 
select 
  product_code 
from 
  product 
where 
  product_id = 1;
explain 
select 
  product_name 
from 
  product 
where 
  product_name = 'iphone 14 promax' 
  and product_price = 9000;
  
-- So sánh câu truy vấn trước và sau khi tạo index
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view v_product as 
select 
  product_code, 
  product_name, 
  product_price, 
  product_status 
from 
  product;
select 
  * 
from 
  v_product;
  
-- Tiến hành sửa đổi view
set 
  sql_safe_updates = 0;
update 
  v_product 
set 
  product_name = 'iphone 12 pro' 
where 
  product_code = 'dt002';
  
-- Tiến hành xoá view
drop 
  view v_product;
  
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter // create procedure sp_product () begin 
select 
  * 
from 
  products;
end // delimiter;
call sp_product();

-- Tạo store procedure thêm một sản phẩm mới
delimiter // create procedure sp_insert_product (
  in product_code varchar(50), 
  in product_name varchar(50), 
  in product_price double, 
  in product_amount int, 
  in product_description varchar(50), 
  in product_status varchar(50)
) begin insert product (
  product_code, product_name, product_price, 
  product_amount, product_description, 
  product_status
) 
values 
  (
    product_code, product_name, product_price, 
    product_amount, product_description, 
    product_status
  );
end // delimiter;
call sp_insert_product(
  'dt004', 'nokia', 6000, 4, 'ngon', 'tốt'
);

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter // create procedure sp_update_product (
  in product_id int, 
  in product_code varchar(50), 
  in product_name varchar(50), 
  in product_price double, 
  in product_amount int, 
  in product_description varchar(50), 
  in product_status bit
) begin 
update 
  product 
set 
  product_code = product_code, 
  product_name = product_name, 
  product_price = product_price, 
  product_amount = product_amount, 
  product_description = product_description, 
  product_status = product_status 
where 
  product_id = product_id;
end // delimiter;
call sp_update_product(
  1, 'dt002', 'iphone', 2000, 2, 'ngon', 
  'ổn'
);

-- Tạo store procedure xoá sản phẩm theo id
delimiter // create procedure sp_delete_product (in product_id int) begin 
delete from 
  product 
where 
  product_id = product_id;
end // delimiter;
call sp_delete_product(3);

