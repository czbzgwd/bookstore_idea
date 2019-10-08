package com.atguigu.bookstore.domain;

/**
 *2019��1��7������10:30:17
 *
 */
public class ShoppingCartItem {

	private Book book;
	private int quantity;
	public ShoppingCartItem(Book book) {
		this.book = book;
		this.quantity = 1;
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
	public float getItemPrice(){
		return book.getPrice()*quantity;
	}
	/**
	 * ʹ��Ʒ���� + 1
	 */
	public void increment(){
		 quantity++;
	}
	
}
