<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/3/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product management</title>
</head>
<body>
<h1>Thêm mới sản phẩm</h1>
<h3><a href="/product">Quay lại danh sách</a></h3>
<h4 style="color: red">${mess}</h4>
<form action="/product?action=create" method="post">
    <input name="id" placeholder="nhập id sản phẩm">
    <input name="name" placeholder="nhập tên sản phẩm">
    <input name="price" placeholder="nhập giá sản phẩm">
    <button type="submit">Save</button>
</form>
</body>
</html>
