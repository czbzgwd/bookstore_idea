package com.atguigu.bookstore.domain;

/**
 *2019年1月7日上午10:30:17
 *2019年10月21日21:35:10
 *封装了购物车中的商品，以及对书的引用和数量
 */

public class ShoppingCartItem {

	private Book book;
	private int quantity;
	public ShoppingCartItem(Book book) {
		this.book = book;
		this.quantity = 1;//初始化书的数量，就是刚添加进购物车的时候书的数量是1.
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
	 * 返回该商品在购物车中的钱数
	 * @return
	 */
	public float getItemMoney(){
		return book.getPrice()*quantity;
	}
	/**
	 * 使商品数量 + 1
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
