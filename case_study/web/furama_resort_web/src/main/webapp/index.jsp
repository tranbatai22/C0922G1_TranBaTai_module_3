<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05/12/2022
  Time: 9:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Home</title>
  <link rel="stylesheet" href="../bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<%@include file="view/include/header.jsp"%>

<div class="row">
  <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 ">
    <ul class="list-group vh-100 overflow-scroll" style="border: 1px solid #7952b3;">
      <li class="list-group-item ">An active item</li>
      <li class="list-group-item ">A second item</li>
      <li class="list-group-item ">A third item</li>
      <li class="list-group-item ">An active item</li>
    </ul>
  </div>
  <div class="col-xs-12 col-sm-6 col-md-8 col-lg-9">
    <div class="row">
      <img src="picture/body.jpg" class="vh-100" alt="ảnh lỗi"/>
      <p>THIS WORLD CLASS RESORT, FURAMA DANANG, REPUTABLE FOR BEING A CULINARY RESORT IN VIETNAM</p>
    </div>
  </div>
</div>
<%@include file="view/include/footer.jsp"%>
</body>
<script src="../bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</html>