package com.atguigu.bookstore.dao;

import java.util.Collection;
import java.util.Set;

import com.atguigu.bookstore.domain.TradeItem;

/**
 *2019��1��7������11:42:33
 *
 */
public interface TradeItemDAO {
	/**
	 * �������� TradeItem ����
	 * @param items
	 */
	public abstract void batchSave(Collection<TradeItem> items);
	/**
	 * ���� tradeId ��ȡ��������� TradeItem �ļ���
	 * @param tradeId
	 * @return
	 */
	public abstract Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId);

}
