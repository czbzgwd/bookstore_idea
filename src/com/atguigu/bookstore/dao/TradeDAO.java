package com.atguigu.bookstore.dao;

import java.util.Set;

import com.atguigu.bookstore.domain.Trade;

/**
 *2019��1��7������11:08:33
 *
 */
public interface TradeDAO {
	/**
	 * �����ݱ��в��� Trade ����
	 * @param trade
	 */
	public abstract void insert(Trade trade);
	/**
	 * ���� userId ��ȡ��������� Trade �ļ���
	 * @param userId
	 * @return
	 */
	public abstract Set<Trade> getTradesWithUserId(Integer userId);

}
