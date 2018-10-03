<%@ page import="ru.innopolis.stc13.pojo.Brand" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rikki
  Date: 01.10.2018
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brands list</title>
</head>
<body>
<H1>Список брендов телефонов в продаже:</H1>
<%
    List<Brand> list = (List<Brand>) request.getAttribute("brands");
    for (Brand brand : list) {%>
<a href="/phones?id=<%=brand.getId()%>"><%=brand.getName()%>
</a><BR>
<%
    }
%>
<a href="/createManufacturer">Create Brand</a>
</body>
</html>
