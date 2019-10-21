package com.atguigu.bookstore.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *2019年10月21日22:16:05
 *
 */
public class ShoppingCart {
    private Map<Integer,ShoppingCartItem> books = new HashMap<>();

    //向购物车中添加商品
    public void addBook(Book book){
       //1、检查购物车中是否有该商品，如果有，那么商品数量加1；若没有，新创建对应的
       // ShoppingCartItem,并将其加入到books中。
        ShoppingCartItem sci = books.get(book.getId());
        if(sci == null){
            //创建一个新的ShoppingCartItem
            sci = new ShoppingCartItem(book);
            //添加到books中
            books.put(book.getId(),sci);
        }else{
            sci.increment();
        }
    }
    //判断购物车中是否有id指定的商品
    public boolean hasBook(Integer id){
       /* ShoppingCartItem sci = books.get(id);
        if(sci == null){
            return false;
        }else{
            return true;
        }*/
        return books.containsKey(id);
    }

    public Map<Integer, ShoppingCartItem> getBooks() {
        return books;
    }

    //获取购物车中所有的ShoppingCartItem组成的集合
    public Collection<ShoppingCartItem> getItems(){
         return books.values();
    }

    /**
     * 返回购物车中商品的总数量☆
     * @return
     */
    public int getBookNumber(){
        int total = 0;
        for(ShoppingCartItem sci:books.values()){
          total += sci.getQuantity();
        }
        return total;
    }

    public float getTotalMoney(){
        float total = 0;
        for(ShoppingCartItem sci:getItems()){
            total += sci.getItemMoney();
        }
        return total;
    }

    public boolean isEmpty(){
        return books.isEmpty();
    }

    //清空购物车
    public void clear(){
        books.clear();
    }
    //移除指定的购物项
    public void removeItem(Integer id){
        books.remove(id);
    }

    //修改指定购物项的数量
    public void updateItemQuantity(int id,int quantity){
        ShoppingCartItem sci = books.get(id);
        if(sci != null){
            sci.setQuantity(quantity);
        }
    }

}
