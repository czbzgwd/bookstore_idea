package com.atguigu.bookstore.domain;

/**
 *2019��1��7������10:30:17
 *2019��10��21��21:35:10
 *��װ�˹��ﳵ�е���Ʒ���Լ���������ú�����
 */

public class ShoppingCartItem {

	private Book book;
	private int quantity;
	public ShoppingCartItem(Book book) {
		this.book = book;
		this.quantity = 1;//��ʼ��������������Ǹ���ӽ����ﳵ��ʱ�����������1.
	}
	
	public Book getBook() {
		return book;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * ���ظ���Ʒ�ڹ��ﳵ�е�Ǯ��
	 * @return
	 */
	public float getItemMoney(){
		return book.getPrice()*quantity;
	}
	/**
	 * ʹ��Ʒ���� + 1
	 */
	public void increment(){
		 quantity++;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem{" +
				"book=" + book +
				", quantity=" + quantity +
				'}';
	}
}
