use student_management;

--  Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select 
  * 
from 
  `subject` 
where 
  credit in (
    select 
      max(credit) 
    from 
      `subject`
  );
  
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select 
  sb.*, 
  max(mark) as max_mark 
from 
  `subject` sb 
  join mark m on m.sub_id = sb.sub_id 
group by 
  sb.sub_id;
  
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select 
  s.*,
  avg(mark) as average 
from 
  student s 
  join mark m on m.student_id = s.student_id 
group by 
  s.student_id 
order by 
  avg(mark) desc;
