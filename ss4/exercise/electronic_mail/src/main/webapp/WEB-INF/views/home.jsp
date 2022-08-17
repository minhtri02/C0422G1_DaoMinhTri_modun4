<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="justify-content: center;display: flex">
    <form:form action="/showBoxEmail" method="post" modelAttribute="boxEmail">
        <fieldset style="width: 300px">
            <legend>SETTING BOX EMAIL</legend>
            <table>
                <tr>
                    <td>
                        <form:label path="language">languages</form:label>
                    </td>
                    <td>
                        <form:select path="language" items="${language}"></form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Page size: </label>
                    </td>
                    <td>
                        <label>Show</label>
                        <form:select path="pageSize" items="${pageSize}"></form:select>
                        <label>email per page</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Spams filter</label>
                    </td>
                    <td>
                        <form:checkbox path="spamFilter"></form:checkbox>
                        <label>Enable spams filter</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Signature</label>
                    </td>
                    <td>
                        <form:textarea path="signature"></form:textarea>
                    </td>

                </tr>
                <tr>
                    <td><form:button>Update</form:button></td>
                    <td>
                        <button type="button">Cancel</button>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form:form>
</div>
</body>
</html>
