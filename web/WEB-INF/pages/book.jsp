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
<table cellpadding="10">
    <%--<c:forEach items="${bookDetail.list }" var="book">--%>
        <tr>
            <td><h3>${book.title }</h3>
                <br>
            </td>
            <td>
                    ${book.author}
            </td>
            <td>
                    ${book.price}
            </td>
            <td>
                    ${book.publishingDate}
            </td>
            <td>
                    ${book.salesAmount}
            </td>
            <td>
                    ${book.storeNumber}
            </td>
            <td>
                    ${book.remark}
            </td>
            <td>
                <a href="">加入购物车</a>
            </td>
        </tr>
   <%-- </c:forEach>--%>
</table>
</body>
</html>
