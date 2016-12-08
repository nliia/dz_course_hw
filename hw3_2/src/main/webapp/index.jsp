<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Search files</h2>

<form action="searcher" method="get">
    <input type="text" name="path" placeholder="path">
    <input type="text" name="name" placeholder="name">
    <button type="submit">OK</button>
</form>

<br><h2>Sum</h2>
<form action="sumServlet" method="get">
    <input type="number" name="first" placeholder="first number">
    <input type="number" name="second" placeholder="second number">
    <button type="submit">OK</button>
</form>
</body>
</html>
