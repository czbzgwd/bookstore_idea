package com.atguigu.bookstore.test;

import com.atguigu.bookstore.dao.BookDAO;
import com.atguigu.bookstore.dao.impl.BookDAOImpl;
import com.atguigu.bookstore.domain.Book;
import com.atguigu.bookstore.web.CriteriaBook;
import com.atguigu.bookstore.web.Page;
import org.junit.Test;

import java.util.List;

public class BookDAOTest {
    private BookDAO bookDAO = new BookDAOImpl();
    @Test
    public void testPage(){
        CriteriaBook cb = new CriteriaBook(0,90,2);
        Page page = bookDAO.getPage(cb);
        System.out.println(page.getPageNo());
        System.out.println(page.getList());
        System.out.println(page);
    }

    @Test
    public void testGetTotalBookNumber() {
        CriteriaBook cb = new CriteriaBook(0,1000,666);
        System.out.println(bookDAO.getTotalBookNumber(cb));;
    }

    @Test
    public void getBook() {
        Book book = bookDAO.getBook(2);
        System.out.println(book);
    }

    //获取书籍列表
    @Test
    public void getPageList(){
        CriteriaBook cb = new CriteriaBook(0,1000,6);
        List list = bookDAO.getPageList(cb,3);
        System.out.println(list);
    }

    //获取书的库存
    @Test
    public void getStoreNumber(){
        System.out.println(bookDAO.getStoreNumber(2));
    }
}
