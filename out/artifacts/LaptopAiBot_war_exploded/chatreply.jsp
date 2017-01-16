<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Gaurav
  Date: 16/01/17
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Laptop Manager</title>
</head>
<body>

<p>
    <c:forEach items="${reply}" var="line">
        <tr>
            <td>${line}</td>
        </tr>
        <br />
    </c:forEach>
</p>
<form action="chat" method="post">
    <br>
    <input type="text" name="request" ><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
