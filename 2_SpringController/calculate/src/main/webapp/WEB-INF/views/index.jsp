<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div>
    <h1>Caculator</h1>
</div>
<div>
    <form action="/result" method="post">
    <table>
        <tr>
            <td colspan="2"><label>Number1</label><input type="text" name="num1" value="${num1}"></td>
            <td colspan="2"><label>Number2</label><input type="text" name="num2" value="${num2}"></td>
        </tr>
        <tr>
            <td><button type="submit" name="calculation" value="addition">Addition(+)</button></td>
            <td><button type="submit" name="calculation" value="subtraction">Subtraction(-)</button></td>
            <td><button type="submit" name="calculation" value="multiplication">Multiplication(x)</button></td>
            <td><button type="submit" name="calculation" value="division">Division(/)</button></td>
        </tr>
    </table>
    </form>
</div>
<div>Result: ${result}</div>
</body>
</html>