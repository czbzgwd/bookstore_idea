package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.TradeDAO;
import com.atguigu.bookstore.domain.Trade;
import java.util.LinkedHashSet;
import java.util.Set;
public class TradeDAOImpl extends BaseDAO<Trade> implements TradeDAO {
    @Override
    public void insert(Trade trade) {
       String sql = "insert into trade (userid,tradetime) values (?,?)";
       //获取交易的编号
       long id =  insert(sql,trade.getUserId(),trade.getTradeTime());
       trade.setTradeId((int)id);
    }
    @Override
    public Set<Trade> getTradesWithUserId(Integer userId) {
        String sql = "select * from trade where userId = ? order by tradetime desc";
        Set<Trade> set = new LinkedHashSet<Trade>(queryForList(sql,userId)) ;
        return set;
    }
}
