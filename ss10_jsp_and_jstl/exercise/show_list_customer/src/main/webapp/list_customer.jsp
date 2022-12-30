<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/29/2022
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<table class="table table-striper">
    <tr>
        <td class="table-primary">STT</td>
        <td class="table-secondary">Tên</td>
        <td class="table-success">Ngày sinh</td>
        <td class="table-danger">Địa chỉ</td>
        <td class="table-warning">Ảnh</td>
    </tr>
    <c:forEach varStatus="item" var="customer" items="${customerList}">
        <tr>
            <td class="table-primary">${item.count}</td>
            <td class="table-secondary">${customer.name}</td>
            <td class="table-success">${customer.date}</td>
            <td class="table-danger">${customer.address}</td>
            <td class="table-warning"><img src="${customer.image}" width="100px" height="100px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
