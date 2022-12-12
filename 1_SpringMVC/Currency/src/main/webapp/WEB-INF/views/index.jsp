<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div>
    <h1>Currency conversion</h1>
</div>
<div>
    <form action="/conversion" method="post">
        <label>Enter Number</label>
        <input type="text" name="num" placeholder="Enter number"><br>
        <label>Conversion type:</label>
        <select name="type">
            <option value="23000">USD to VND</option>
            <option value="1/23000">VND to USD</option>
        </select><br>
        <label>Result:</label>
        <input type="text" value="${result}" readonly ><br>
        <button type="submit">Conversion</button>
    </form>
</div>
</body>
</html>