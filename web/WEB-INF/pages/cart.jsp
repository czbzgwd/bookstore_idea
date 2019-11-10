<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/9 0009
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    您的购物车中共有：${sessionScope.ShoppingCart.bookNumber}本书

    <br>
    <table cellpadding="10">
    <tr>
        <td>书名</td>
        <td>数量</td>
        <td>价格</td>
    </tr>

        <c:forEach items="${sessionScope.ShoppingCart.items}" var="item">
    <tr>
        <td>${item.book.title}</td>
        <td>${item.book.price}</td>
        <td>${item.quantity}</td>
        <td><a href="">删除</a></td>
    </tr>
        </c:forEach>
        <br>
        <tr colspan="4">
            总金额：${sessionScope.ShoppingCart.totalMoney}
        </tr>
        <tr colspan="4">
            <td><a href="">继续购物</a></td>
            <td><a href="">清空购物车</a></td>
            <td><a href="">结账</a></td>
        </tr>
    </table>
</center>
</body>
</html>
