package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.AccountDAO;
import com.atguigu.bookstore.domain.Account;

public class AccountDAOImpl extends BaseDAO<Account> implements AccountDAO {
    @Override
    public Account getAccount(Integer accountId) {
        String sql = "select * from account where accountId = ?";
       // return getSingleVal(sql,accountId);//java.lang.ClassCastException: java.lang.Integer cannot be cast to com.atguigu.bookstore.domain.Account
        return query(sql,accountId);
    }

    @Override
    public void updateBalance(Integer accountId, float amount) {
        String sql = "update account set balance = balance - ? where accountId = ?";
        update(sql,amount,accountId);
    }
}
