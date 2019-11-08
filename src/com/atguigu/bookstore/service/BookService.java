package com.atguigu.bookstore.service;

import com.atguigu.bookstore.dao.BookDAO;
import com.atguigu.bookstore.dao.impl.BookDAOImpl;
import com.atguigu.bookstore.domain.Book;
import com.atguigu.bookstore.domain.ShoppingCart;
import com.atguigu.bookstore.web.CriteriaBook;
import com.atguigu.bookstore.web.Page;

public class BookService {
    private BookDAO bookDAO = new BookDAOImpl();
    //获取书本分页信息
    public Page<Book> getPage(CriteriaBook cb){
      Page<Book> page = bookDAO.getPage(cb);
      return page;
    }
    //获取书本详情
    public Book getBookDetail(int id){
        Book book = bookDAO.getBook(id);
        return book;
    }
    //将书添加进购物车
    public boolean addToCart(int id, ShoppingCart sc){
        Book book = bookDAO.getBook(id);
        if(book != null){
            sc.addBook(book);
            return true;
        }else{
            return false;
        }
    }
}
