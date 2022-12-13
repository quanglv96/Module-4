<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div>
<h1>Sandwich Condiments</h1>
</div>
<div>
    <form id="tick" action="/home" method="post">
        <c:forEach var="menu" items="${menu}">
            <input type="checkbox"name="checkbox" value="${menu.getName()}">${menu.getName()}
        </c:forEach>
        <button type="submit">Add</button>
    </form>
</div>
<div>
    <c:forEach items="${option}" var="opp">
        <p>${opp}</p>
    </c:forEach>
</div>
</body>
</html>