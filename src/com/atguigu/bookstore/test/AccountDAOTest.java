package com.atguigu.bookstore.test;

import com.atguigu.bookstore.dao.AccountDAO;
import com.atguigu.bookstore.dao.impl.AccountDAOImpl;
import com.atguigu.bookstore.domain.Account;
import org.junit.Test;

public class AccountDAOTest {
    private AccountDAO accountDAO = new AccountDAOImpl();

    @Test
    public void getAccount() {
        System.out.println(accountDAO.getAccount(1));
    }

    @Test
    public void updateAccount(){
        accountDAO.updateBalance(1,200);
    }
}
