<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div><h1>Check Validate Email</h1></div>
<div>
    <form action="/email" method="post">
        <input type="text" name="email" value="${email}">
        <button type="submit">Check</button>
    </form>
</div>
<div>
    <p>${result}</p>
</div>
</body>
</html>