<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="java.util.List" %>
<%
    Long id=Long.parseLong(request.getParameter("id"));
    Customer customers = CustomerServiceFactory.getInstance().findOne(id);
%>
<form action="/customers" method="post">
<fieldset>
    <legend>Customer Information</legend>
    <input type="hidden" name="id" value="<% customers.getId();%>">
    <table>
        <tr>
            <td>Id</td>
            <td>
                <% customers.getId();%>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name" value="<% customers.getName();%>">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" value="<% customers.getEmail();%>">
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
                <input type="text" name="address" value="<% customers.getAddress();%>">
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
<a href="/customers/list.jsp">Back to list</a>.