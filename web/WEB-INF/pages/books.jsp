<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/12
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="../../script/jquery-1.7.2.min.js"></script>
<head>
    <title>网上书城</title>
</head>
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
        });
        $("#page").change(function(){
            //1、获取输入的值
            var val = $(this).val();
            //2、去除字符串的头尾空格
            val = $.trim(val);
            //3、判断输入的字符是否是数字
            var flag = false;
            var reg = /^\d+$/g;
            var pageNo = 0;
            if(reg.test(val)){
               pageNo = parseInt(val);
              if(pageNo >=1 && pageNo <= parseInt("${bookPage.totalPageNumber}")){
                  flag = true;
              }
            }
            if(!flag){
                alert("请输入合法的字符！");
                $(this).val("");
                return false;
            }
            var href = "bookServlet?method=getBooks&pageNo="+pageNo+"&" +$(":hidden").serialize();
            window.location.href = href;
        })
    })
</script>
<body>
<center>
    <%--EL表达式${param.xxx}可以从url中获取参数放在页面中直接使用
比如：一个网址：127.0.0.1/test/testparam?test1=3&test2=sss
用${param.test1}就可以直接获取到test1的值，也就是3
用${param.test2}就可以直接获取到test2的值，也就是sss
${param.xxx} 就等价于 request.getparam("xxx")，也就是服务器从页面或者客户端获取的内容--%>
    <input type="hidden" name="minPrice" value="${param.minPrice }"/>
    <input type="hidden" name="maxPrice" value="${param.maxPrice }"/>
    <form action="bookServlet?method=getBooks" method="post">
        Price:
        <input type="text" size="1" name="minPrice"/> -
        <input type="text" size="1" name="maxPrice"/>

        <input type="submit" value="Submit"/>
    </form>
    <table cellpadding="10">
        <c:forEach items="${bookPage.list }" var="book">
            <tr>
                <td><a href="bookServlet?method=getBookDetail&pageNo=${bookPage.pageNo}&id=${book.id}">${book.title }</a>
                    <br>
                        ${book.author}
                </td>
                <td>
                        ${book.price}
                </td>
                <td>
                    <a href="">加入购物车</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    共 ${bookPage.totalPageNumber } 页&nbsp;&nbsp;
    当前第${bookPage.pageNo }页&nbsp;&nbsp;
    <c:if test="${bookPage.hasPrev}">
        <a href="bookServlet?method=getBooks&pageNo=1">首页</a>
        <a href="bookServlet?method=getBooks&pageNo=${bookPage.prevPage}">上一页</a>
    </c:if>
    <c:if test="${bookPage.hasNext}">
        <a href="bookServlet?method=getBooks&pageNo=${bookPage.nextPage}">下一页</a>
        <a href="bookServlet?method=getBooks&pageNo=${bookPage.totalPageNumber }">末页</a>
    </c:if>&nbsp;&nbsp;
    跳转到<input type="text" size="1" id = "page"/>页
</center>
</body>
</html>
