<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2022
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
<div class="container d-flex justify-content-center ">
    <form action="/home" class="form-select-button">
        <table class="table-cell table">
            <tr>
                <th><h2>CHANGE MONEY</h2></th>
            </tr>
            <tr>
                <th><label>USD: </label><input name="usd" type="text" value="${usd}"  placeholder="enter number"></th>
            </tr>
            <tr>
                <td>
                    <button class="button btn-primary" type="submit">result</button>
                </td>
            </tr>
            <tr>
                <td>VNĐ: ${vnd}</td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
