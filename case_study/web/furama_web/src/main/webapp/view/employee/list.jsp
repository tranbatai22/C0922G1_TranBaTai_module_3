<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 08/12/2022
  Time: 10:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="../../bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<script src="../../bootstrap-5.1.3-dist/js/bootstrap.js"></script>

<%@include file="../include/header.jsp" %>

<a href="/employee?action=add" class="btn btn-warning">Thêm mới</a>

<h2 class="d-flex justify-content-center text-danger">Employee List</h2>
<h3 class="text-success">${mess}</h3>

<%------------------------------------------Search-------------------------------------------------%>
<form class="d-flex" action="/employee?action=search" method="post">
    <input class="form-control me-2" type="search" placeholder="Search Name" aria-label="Search" name="name">
    <input class="form-control me-2" type="search" placeholder="Search Phone Number" aria-label="Search"
           name="phone_number">
    <input class="form-control me-2" type="search" placeholder="Search Address" aria-label="Search" name="address">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>

<table class="table table-striped table-hover" id="tableStudent">
    <thead>
    <tr class="text-center btn-info">
        <th scope="col">STT</th>
        <th scope="col">Employee Name</th>
        <th scope="col">Date Of Birth</th>
        <th scope="col">ID Card</th>
        <th scope="col">Salary</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Position Name</th>
        <th scope="col">Education Degree Name</th>
        <th scope="col">Division Name</th>
        <th scope="col">User Name</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employeeList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${employee.name}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.idCard}</td>
            <td>${employee.salary}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.email}</td>
            <td>${employee.address}</td>
            <td>${employee.position.name}</td>
            <td>${employee.educationDegree.name}</td>
            <td>${employee.division.name}</td>
            <td>${employee.user.userName}</td>
            <td>
                <button onclick="infoEdit('${employee.getId()}','${employee.getName()}','${employee.getDateOfBirth()}',
                        '${employee.getIdCard()}','${employee.getPhoneNumber()}','${employee.getSalary()}',
                        '${employee.getEmail()}','${employee.getAddress()}','${employee.position.getId()}',
                        '${employee.educationDegree.getId()}','${employee.division.getId()}','${employee.user.getUserName()}')"
                        type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#edit">
                    Edit
                </button>
            </td>
            <td>
                <button onclick="infoDelete('${employee.getId()}','${employee.getName()}')" type="button"
                        class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@include file="../include/footer.jsp" %>

<%-- modal delete--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/customer?action=delete" method="post">
                <div class="modal-body">
                    <label for="deleteId"></label><input type="text" hidden id="deleteId" name="id">
                    Bạn có muốn xóa khách hàng <span id="deleteName" style="color: brown; font-weight: bold"></span>
                    không ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Confirm</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Modal edit -->
<div class="modal fade" id="edit" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <form action="/customer?action=edit" method="post" class="form-xl">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel1">Chỉnh sửa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="id" hidden id="idEdit" type="text">
                    <div class="m-2 row">
                        <label class="col-sm-3 col-form-label">Customer Type Name</label>
                        <div class="col-sm-9">
                            <select class="form-select" name="customer_type_id" id="customerTypeIdEdit">
                                <c:forEach var="ct" items="${customerTypeList}">
                                    <option value="${ct.id}">${ct.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="m-2 row">
                        <label for="nameEdit" class="col-sm-3 col-form-label">Name</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="nameEdit" name="name">
                        </div>
                    </div>
                    <div class="m-2 row">
                        <label for="dateEdit" class="col-sm-3 col-form-label">Date Of Birth</label>
                        <div class="col-sm-9">
                            <input type="date" class="form-control" id="dateEdit" name="date_of_birth">
                        </div>
                    </div>
                    <div class="m-2 row">
                        <div class="col-sm-3">Gender</div>
                        <div class="col-sm-9" >
                            <label><input type="radio" name="gender" value="true" id="male">Nam</label>
                            <label><input type="radio" name="gender" value="false" id="female">Nữ</label>
                        </div>
                    </div>
                    <div class="m-2 row">
                        <label for="idCardEdit" class="col-sm-3 col-form-label">ID Card</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="idCardEdit" name="id_card">
                        </div>
                    </div>
                    <div class="m-2 row">
                        <label for="phoneNumberEdit" class="col-sm-3 col-form-label">Phone Number</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="phoneNumberEdit" name="phone_number">
                        </div>
                    </div>
                    <div class="m-2 row">
                        <label for="emailEdit" class="col-sm-3 col-form-label">Email</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="emailEdit" name="email">
                        </div>
                    </div>
                    <div class="m-2 row">
                        <label for="addressEdit" class="col-sm-3 col-form-label">Address</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="addressEdit" name="address">
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function infoDelete(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
    function infoEdit(id, customerTypeId, name, date_of_birth, id_card, phone_number, email, address, gender) {
        document.getElementById("idEdit").value = id;
        document.getElementById("customerTypeIdEdit").value = customerTypeId;
        document.getElementById("nameEdit").value = name;
        document.getElementById("dateEdit").value = date_of_birth;
        document.getElementById("idCardEdit").value = id_card;
        document.getElementById("phoneNumberEdit").value = phone_number;
        document.getElementById("emailEdit").value = email;
        document.getElementById("addressEdit").value = address;
        if (gender === "true") {
            document.getElementById("male").checked = true;
            document.getElementById("female").checked = false;
        } else {
            document.getElementById("male").checked = false;
            document.getElementById("female").checked = true;
        }
    }
</script>
<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableStudent').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
        // $("#edit").modal('show');
    } );
</script>
</body>
</html>