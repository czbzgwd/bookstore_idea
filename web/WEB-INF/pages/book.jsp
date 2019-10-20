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
<script type="text/javascript" src="../../script/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("a").click(function () {
            //这段代码的作用就是输入价格区间后点击分页能够实现带上价格区间的页面跳转
            var serializeVal = $(":hidden").serialize();
            //serializeVal的值为minPrice=30&maxPrice=60
            // var serializeVal1 = $(":hidden");//此时serializeVal1的值是object
            var href = this.href + "&" + serializeVal;
            /*
            window.location.href=window.location.href;和window.location.Reload()和都是刷新当前页面。
            区别在于是否有提交数据。当有提交数据时，window.location.Reload()会提示是否提交，
            window.location.href=window.location.href;则是向指定的url提交数据
             */
            window.location.href = href;
            return false;
        })
    });
</script>
<head>
    <title>书本详情</title>
</head>
<body>
<input type="hidden" name="minPrice" value="${param.minPrice }"/>
<input type="hidden" name="maxPrice" value="${param.maxPrice }"/>
<center>

    <br>
    <br> Title: ${book.title }
    <br>
    <br> Author: ${book.author } <br>
    <br> Price: ${book.price } <br>
    <br> PublishingDate: ${book.publishingDate } <br>
    <br> Remark: ${book.remark } <br>
    <br>
    <a href="bookServlet?method=getBooks&pageNo=${param.pageNo}">继续购物</a>
</center>
</body>
</html>
