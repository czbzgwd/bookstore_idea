package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.domain.User;

/**
 *2019��1��7������11:51:33
 *
 */
public interface UserDAO {
	/**
	 * �����û�����ȡ User ����
	 * @param username
	 * @return
	 */
	public abstract User getUser(String userName);

}
