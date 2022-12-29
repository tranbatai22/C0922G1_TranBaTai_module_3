<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/29/2022
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculate_discount" method="get">
    <p>Nhập mô tả sản phẩm</p>
    <input type="text" name="ProductDescription"><br>
    <p>Nhập giá sản phẩm</p>
    <input type="text" name="ListPrice"><br>
    <p>Nhập tỉ lệ chiết khấu của sản phẩm</p>
    <input type="text" name="DiscountPercent"><br><br>
    <button type="submit">Calculate Discount</button>
</form>
</body>
</html>
