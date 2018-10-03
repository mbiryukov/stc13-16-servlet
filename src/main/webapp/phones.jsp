<%@ page import="ru.innopolis.stc13.pojo.Mobile" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rikki
  Date: 01.10.2018
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Список телефонов бренда <%=request.getAttribute("brand")%> в продаже:</H1>
<%
    List<Mobile> list = (List<Mobile>) request.getAttribute("mobiles");
    for (Mobile mobile : list) {%>
<%=mobile.getId()%> <%=mobile.getModel()%> <%=mobile.getPrice()%><BR>
<%
    }
%>
</body>
</html>
