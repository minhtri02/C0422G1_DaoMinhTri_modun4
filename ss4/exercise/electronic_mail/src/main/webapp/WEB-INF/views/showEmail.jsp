<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: flex;justify-content: center">
    <div style="border: 1px solid black;width: 400px;text-align: center">
        <h2 style="color: darkblue">BOX EMAIL</h2>
        <h3>languages : ${boxEmail.language}</h3>
        <h3>Page size : ${boxEmail.pageSize}</h3>
        <h3>Spam filter :
            <c:if test="${boxEmail.spamFilter == true}">enable</c:if>
            <c:if test="${boxEmail.spamFilter == false}">disable</c:if>
        </h3>
        <h3>Signature : ${boxEmail.signature}</h3>
    </div>
</div>
</body>
</html>
