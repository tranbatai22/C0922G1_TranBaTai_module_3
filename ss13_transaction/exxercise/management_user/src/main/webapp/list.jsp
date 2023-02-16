<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/16/2023
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Stt</td>
        <td>Name Song</td>
        <td>Name Singer</td>
        <td>Name Type</td>
    </tr>
    <c:forEach var="playList" items="${playList}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${playList.nameSong}</td>
            <td>${playList.singer.singerName}</td>
            <td>${playList.typeSong.typeName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
