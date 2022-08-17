<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Họ và Tên</td>
        <td>Năm Sinh</td>
        <td>Giới tính</td>
        <td>Quốc tịch</td>
        <td>CMND</td>
        <td>Thông tin đi lại</td>
        <td>Số hiệu phương tiện</td>
        <td>Số ghế</td>
        <td>Hành động</td>
    </tr>
    <tr>
        <td>${medical.id}</td>
        <td>${medical.name}</td>
        <td>${medical.yearOfBirt}</td>
        <td>${medical.gender}</td>
        <td>${medical.nationality}</td>
        <td>${medical.idCard}</td>
        <td>${medical.transport}</td>
        <td>${medical.idVehicle}</td>
        <td>${medical.idSeat}</td>
        <td>
            <button onclick="location.href='/edit?id=${medical.id}'">Sửa</button>
        </td>
    </tr>
    <a href="/">Quay về trang thêm mới</a>
</table>
</body>
</html>
