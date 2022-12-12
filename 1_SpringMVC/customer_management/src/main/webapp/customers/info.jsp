<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/saveInfo" method="post">
<fieldset>
    <legend>Customer Information</legend>
    <input type="hidden" name="id" value="${customers.getId()}">
    <table>
        <tr>
            <td>Id</td>
            <td>
                <c:out value="${customers.getId()}"/>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name" value="${customers.getName()}">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" value="${customers.getEmail()}">
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
                <input type="text" name="address" value="${ customers.getAddress()}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</fieldset>
</form>
<a href="/customers">Back to list</a>.