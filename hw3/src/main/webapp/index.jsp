<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Enter your name</h2>

    <form action="simple" method="get">
        <input type="text" name="username" placeholder="login">
        <input type="password" name="password" placeholder="password">
        <button type="submit">OK</button>
    </form>

    <c:if test="${isLogged}">
    <p><c:out value="${message}"/><p>
    </c:if>

</body>
</html>
