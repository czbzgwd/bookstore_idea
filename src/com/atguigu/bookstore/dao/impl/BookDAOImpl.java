package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.BookDAO;
import com.atguigu.bookstore.domain.Book;
import com.atguigu.bookstore.domain.ShoppingCartItem;
import com.atguigu.bookstore.web.CriteriaBook;
import com.atguigu.bookstore.web.Page;

import java.util.Collection;
import java.util.List;

/**
 *2019年10月10日下午3:57:45
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO{

    @Override
    public Book getBook(int id) {
        String sql = "select * from mybooks where id = ?";
        return query(sql,id);
    }

    //☆
    public Page<Book> getPage(CriteriaBook cb){
      Page page = new Page(cb.getPageNo());
      page.setTotalItemNumber(getTotalBookNumber(cb));
      cb.setPageNo(page.getPageNo());
      page.setList(getPageList(cb,3));
      return page;
    }

    //获取书的数量
    @Override
    public long getTotalBookNumber(CriteriaBook cb) {
        String sql = "select count(id) from mybooks where price >= ? and price <=?";
        return getSingleVal(sql, cb.getMinPrice(),cb.getMaxPrice());
    }

    @Override
    public List<Book> getPageList(CriteriaBook cb, int pageSize) {
     String sql = "select id,author,title,price,publishingdate,salesamount,storenumber,remark from "+
             "mybooks where price >= ? and price <= ?  limit ?,?";
        return queryForList(sql,cb.getMinPrice(),cb.getMaxPrice(),(cb.getPageNo()-1)*pageSize,pageSize);
    }

    @Override
    public int getStoreNumber(Integer id) {
        String sql = "select storenumber from mybooks where id = ?";
        return getSingleVal(sql,id);
    }

    @Override
    public void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items) {

    }


}
