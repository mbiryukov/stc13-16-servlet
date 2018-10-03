<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/createManufacturer" method="post">
    <input type="name" name="name"/>
    <input type="country" name="country"/>
    <input type="submit">
</form>
<%@include file="footer.jsp"%>
