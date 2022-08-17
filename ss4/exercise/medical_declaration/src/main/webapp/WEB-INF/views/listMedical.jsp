<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Medical Declaration</h1>
<a href="/">add Medical Declaration</a>
<table border="1px">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>yearOfBirt</td>
        <td>gender</td>
        <td>nationality</td>
        <td>idCard</td>
        <td>transport</td>
        <td>idVehicle</td>
        <td>idSeat</td>
        <td>Start day</td>
        <td>End day</td>
        <td>city</td>
        <td>action</td>
    </tr>
    <c:forEach items="${listMedical}" var="listMedical">
        <tr>
            <td>${listMedical.id}</td>
            <td>${listMedical.name}</td>
            <td>${listMedical.yearOfBirt}</td>
            <td>${listMedical.gender}</td>
            <td>${listMedical.nationality}</td>
            <td>${listMedical.idCard}</td>
            <td>${listMedical.transport}</td>
            <td>${listMedical.idVehicle}</td>
            <td>${listMedical.idSeat}</td>
            <td>${listMedical.dayStart}-${listMedical.monthStart}-${listMedical.yearStart}</td>
            <td>${listMedical.dayEnd}-${listMedical.monthEnd}-${listMedical.yearEnd}</td>
            <td>${listMedical.city}</td>
            <td>
                <button onclick="location.href='/edit?id=${listMedical.id}'">Edit</button>
                <button onclick="location.href='/details?id=${listMedical.id}'">details</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
