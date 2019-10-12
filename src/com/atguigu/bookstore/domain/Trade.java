package com.atguigu.bookstore.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *2019��1��7������11:12:49
 *
 */
public class Trade {
	private Integer tradeId;
	//�� Trade ������ User �� userId
	private Integer userId;
	private Date tradeTime;
	//Trade �����Ķ�� TradeItem
	private Set<TradeItem> items = new LinkedHashSet<TradeItem>();
	/**
	 * @return the tradeId
	 */
	public Integer getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the tradeTime
	 */
	public Date getTradeTime() {
		return tradeTime;
	}
	/**
	 * @param tradeTime the tradeTime to set
	 */
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	/**
	 * @return the items
	 */
	public Set<TradeItem> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", userId=" + userId + ", tradeTime=" + tradeTime + "]";
	}
	

}
