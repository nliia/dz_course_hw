<%--
  Created by IntelliJ IDEA.
  User: Liia
  Date: 27.09.2016
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${files}" var="file">
        ${file}<br>
    </c:forEach>
</body>
</html>














