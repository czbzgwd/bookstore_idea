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
     书的数量${sessionScope.ShoppingCart.bookNumber}
<br>
     <c:forEach items="${sessionScope.ShoppingCart.items}" var = "item">
       ${item.book.title}-${item.book.price}-${item.quantity}

     </c:forEach>

</body>
</html>
