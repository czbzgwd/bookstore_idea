package com.atguigu.bookstore.test;

import static org.junit.Assert.*;

//import java.sql.Date;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.dao.impl.BaseDAO;
import com.atguigu.bookstore.dao.impl.BookDAOImpl;
import com.atguigu.bookstore.domain.Book;
import com.atguigu.bookstore.domain.Trade;


public class BaseDAOTest {
    private BookDAOImpl bookDAOImpl = new BookDAOImpl();
	@Test
	public void testInsert() {
		String sql = "insert into trade (userid,tradetime) values (?,?)";
	    //long id = bookDAOImpl.insert(sql, 1,new Date(new java.util.Date().getTime()));
	    long id = bookDAOImpl.insert(sql, 1,new Date());
	    System.out.println(id);
	}

	/**
	 * Test method for {@link BaseDAO#update(String, Object[])}.
	 */
	@Test
	public void testUpdate() {
		String sql = "update mybooks set Salesamount = ? where id = ?";
		bookDAOImpl.update(sql, 10, 4);
	}

	
	@Test
	public void testQuery() {
		String sql = "select id,author,title,price,publishingDate,salesAmount,storeNumber,remark"
				+ " from mybooks  where id = ?";
		Book book = bookDAOImpl.query(sql, 4);
		System.out.println(book);
	}

	/**
	 * Test method for {@link BaseDAO#queryForList(String, Object[])}.
	 */
	@Test
	public void testQueryForList() {
		String sql = "select id,author,title,price,publishingDate,salesAmount,storeNumber,remark"
				+ " from mybooks  where price between  ? and ?";
		List<Book> books = bookDAOImpl.queryForList(sql,50,60);
		for (Book book : books){
			System.out.println(book);
		}
		//System.out.println(books);
	}

	@Test
	public void testGetSingleVal() {
		//获取书的数量
		/*String sql = "select count(id) from mybooks";
		Long count = bookDAOImpl.getSingleVal(sql);
		System.out.println(count);*/
		//获取最近一次交易的时间
		String sql1 = "SELECT tradetime FROM trade ORDER BY  tradetime DESC LIMIT 1";
		Date time = bookDAOImpl.getSingleVal(sql1);
		System.out.println(time);
	}

	@Test
	public void testBatch() {
		String sql = "update  mybooks set publishingdate = ? " +
				"where id = ?";
		 
		bookDAOImpl.batch(sql, new Object[]{"2010-3-15",15},new Object[]{"2011-8-15",16},new Object[]{"2019-8-15",17});
	}

}
