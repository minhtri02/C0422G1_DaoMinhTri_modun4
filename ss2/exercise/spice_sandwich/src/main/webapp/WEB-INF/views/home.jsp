<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>CHOOSE SPICE SANDWICH</title>
</head>
<body>
<div>
    <form action="/save" method="post">
        <h1>Sandwich Condiments</h1>
        <table>
            <c:forEach var="spiceSandwich" items="${list}">
                <tr>
                    <td><input type="checkbox" name="spice" value="${spiceSandwich}">${spiceSandwich}</td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="submit" value="submit"></td>
            </tr>
        </table>
    </form>
</div>
<c:if test="${listSpice!=null}">
    <dev>
        <h2>Your sandwich has:</h2>
        <c:forEach items="${listSpice}" var="spice">
            <p> ${spice}</p>
        </c:forEach>
    </dev>
</c:if>
<c:if test="${message!=null}">
    <h3 style="color: red">${message}</h3>
</c:if>
</body>
</html>
