package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.domain.Account;

/**
 * 2019��1��7������9:39:16
 *
 */
public interface AccountDAO {

	/**
	 * ���� accountId ��ȡ��Ӧ�� Account ����
	 * 
	 * @param accountId
	 * @return
	 */
	public abstract Account getAccount(Integer accountId);
	/**
	 * ���ݴ���� accountId, amount ����ָ���˻������: �۳� amount ָ����Ǯ��
	 * 
	 * @param accountId
	 * @param amount
	 */
	public abstract void updateBalance(Integer accountId, float amount);

}
