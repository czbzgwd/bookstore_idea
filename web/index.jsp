<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/8
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎光临</title>
</head>
<body>
<%
    response.sendRedirect(request.getContextPath() + "/bookServlet?method=getBooks");
%>
</body>
</html>
