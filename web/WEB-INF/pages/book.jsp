<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/20
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书本详情</title>
</head>
<body>
<center>

    <br>
    <br> Title: ${book.title }
    <br>
    <br> Author: ${book.author } <br>
    <br> Price: ${book.price } <br>
    <br> PublishingDate: ${book.publishingDate } <br>
    <br> Remark: ${book.remark } <br>
    <br>
</center>
</body>
</html>
