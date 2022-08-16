<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <form action="/calculator" method="post">
        <h2>Calculator</h2>
        <input type="text" name="num1" value="${num1}">
        <input type="text" name="num2" value="${num2}"><br>
        <button type="submit" name="operator" value="+">Addition(+)</button>
        <button type="submit" name="operator" value="-">Subtraction(-)</button>
        <button type="submit" name="operator" value="x">Multiplication(x)</button>
        <button type="submit" name="operator" value="/">Division(/)</button>
    </form>
    <h2>Result Division: ${result}</h2>
</body>
</html>
