<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 06/12/2022
  Time: 10:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
    <link rel="stylesheet" href="../../bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<script src="../../bootstrap-5.1.3-dist/js/bootstrap.js"></script>
<body>
<%@include file="../include/header.jsp"%>
<h1 class="text-center">Thêm mới Khách hàng</h1>
<h3 class="text-success">${mess}</h3>
<form action="/customer?action=insert" method="post">
    <div class="m-2 row">
        <div class="col-sm-2">Customer Type Name</div>
        <div class="col-sm-10">
            <select name="customer_type_id" class="form-select">
                <c:forEach var="ct" items="${customerTypeList}">
                    <option value="${ct.id}">${ct.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="m-2 row">
        <label for="staticName" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="staticName" name="name">
            <span class="text-danger">${error.get("errorName")}</span>
        </div>
    </div>
    <div class="m-2 row">
        <label for="staticDate" class="col-sm-2 col-form-label">Date Of Birth</label>
        <div class="col-sm-10">
            <input type="date" class="form-control" id="staticDate" name="date_of_birth">
        </div>
    </div>
    <div class="m-2 row">
        <div class="col-sm-2">Gender</div>
        <div class="col-sm-10">
            <label>
                <input type="radio" name="gender" value="true">
            </label>Nam
            <label>
                <input type="radio" name="gender" value="false">
            </label>Nữ
        </div>
    </div>
    <div class="m-2 row">
        <label for="staticIdCard" class="col-sm-2 col-form-label">ID Card</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="staticIdCard" name="id_card">
        </div>
    </div>
    <div class="m-2 row">
        <label for="staticPhoneNumber" class="col-sm-2 col-form-label">Phone Number</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="staticPhoneNumber" name="phone_number">
        </div>
    </div>
    <div class="m-2 row">
        <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="staticEmail" name="email">
        </div>
    </div>
    <div class="m-2 row">
        <label for="staticAddress" class="col-sm-2 col-form-label">Address</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="staticAddress" name="address">
        </div>
    </div>
    <button type="submit" class="d-flex justify-content-center" style="margin: 0 auto">Save</button>
</form>
<%@include file="../include/footer.jsp"%>
</body>
</html>