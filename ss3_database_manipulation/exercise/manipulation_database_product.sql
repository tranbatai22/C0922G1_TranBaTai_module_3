use selling_manager;
insert into customer(
  customer_id, customer_name, customer_age
) 
values 
  (1, 'Minh Quan', 10), 
  (2, 'Ngoc Oanh', 20), 
  (3, '  Hong Ha', 50);
insert into `order` (
  order_id, customer_id, order_date, 
  order_total_price
) 
values 
  (1, 1, '2006/3/3', Null), 
  (2, 2, '2006/3/6', Null), 
  (3, 1, '2006/4/5', Null);
insert into product(
  product_id, product_name, product_price
) 
values 
  (1, 'Máy giặt', 3), 
  (2, 'Tủ lạnh', 3), 
  (3, 'Điều hoà', 3), 
  (4, 'Quạt', 3), 
  (5, 'Bếp điện', 3);
insert into order_detail(
  order_id, product_id, order_detail_qty
) 
values 
  (1, 1, 3), 
  (1, 3, 7), 
  (1, 4, 2), 
  (2, 1, 1), 
  (3, 1, 8), 
  (2, 5, 4), 
  (2, 3, 3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select 
  order_id, 
  order_date, 
  order_total_price 
from 
  `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select 
  c.customer_name, 
  p.product_name 
from 
  customer c 
  join `order` o on c.customer_id = o.customer_id 
  join order_detail od on od.order_id = o.order_id 
  join product p on p.product_id = od.product_id;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select 
  customer_name 
from 
  customer 
where 
  customer_id not in (
    select 
      od.customer_id 
    from 
      `order` od
  );
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
--  (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
--  Giá bán của từng loại được tính = odQTY*pPrice)
select 
  o.o_id, 
  o.o_date, 
  od.od_qty, 
  (p.p_price * od.od_qty) as o_total_price 
from 
  customer c 
  join `order` o on c.c_id = o.c_id 
  join order_detail od on od.o_id = o.o_id 
  join product p on p.p_id = od.p_id;

