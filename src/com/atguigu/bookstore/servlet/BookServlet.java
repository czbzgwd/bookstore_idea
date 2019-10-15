package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.web.CriteriaBook;
import com.atguigu.bookstore.web.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            //注意是getDeclaredMethod，位于视频5 20分20秒
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
                    HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            /*throw new RuntimeException(e);*/
        }


    }
    protected void getBooks(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       //获取页面参数
        String pageNoStr = request.getParameter("pageNo");
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");

        //初始化(就是页面加载完成后所获得的数据)
        int pageNo = 1;
        int minPrice = 0;
        int maxPrice = Integer.MAX_VALUE;

        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {
         //e.printStackTrace();//注意这里不能写该句话否则会报错★
            //因为页面刚加载pageNoStr为null所以Integer.parseInt(pageNoStr)必然报异常，那么就会
            //执行catch中的程序，如果catch中没有代码，程序就会往下执行。
        }
        try {
            minPrice = Integer.parseInt(minPriceStr);
        } catch (NumberFormatException e) {

        }
        try {
            maxPrice = Integer.parseInt(maxPriceStr);
        } catch (NumberFormatException e) {

        }
        CriteriaBook cb = new CriteriaBook(minPrice,maxPrice,pageNo);
        Page page = bookService.getPage(cb);
        //System.out.println(page.getList());
        request.setAttribute("bookPage",page);
        request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request,response);
    }

}
