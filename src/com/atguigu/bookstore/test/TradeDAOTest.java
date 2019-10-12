package com.atguigu.bookstore.test;

import com.atguigu.bookstore.dao.TradeDAO;
import com.atguigu.bookstore.dao.impl.TradeDAOImpl;
import com.atguigu.bookstore.domain.Trade;
import org.junit.Test;

import java.util.Date;
import java.util.Set;

public class TradeDAOTest {
    private TradeDAO tradeDAO = new TradeDAOImpl();
    //插入一条交易记录
    @Test
    public void testInsert(){
        Trade trade = new Trade();
        trade.setUserId(2);
        Date d = new Date();
        trade.setTradeTime(d);
        tradeDAO.insert(trade);
        System.out.println(trade.getTradeId());
    }
    //根据指定的用户编号获取该用户交易记录，并按照时间排序
    @Test
    public void getTradesWithUserId(){
       Set<Trade> set =  tradeDAO.getTradesWithUserId(2);
        System.out.println(set);
    }
}
