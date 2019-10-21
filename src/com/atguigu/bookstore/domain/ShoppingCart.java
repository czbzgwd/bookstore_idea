package com.atguigu.bookstore.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *2019��10��21��22:16:05
 *
 */
public class ShoppingCart {
    private Map<Integer,ShoppingCartItem> books = new HashMap<>();

    //���ﳵ�������Ʒ
    public void addBook(Book book){
       //1����鹺�ﳵ���Ƿ��и���Ʒ������У���ô��Ʒ������1����û�У��´�����Ӧ��
       // ShoppingCartItem,��������뵽books�С�
        ShoppingCartItem sci = books.get(book.getId());
        if(sci == null){
            //����һ���µ�ShoppingCartItem
            sci = new ShoppingCartItem(book);
            //��ӵ�books��
            books.put(book.getId(),sci);
        }else{
            sci.increment();
        }
    }
    //�жϹ��ﳵ���Ƿ���idָ������Ʒ
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

    //��ȡ���ﳵ�����е�ShoppingCartItem��ɵļ���
    public Collection<ShoppingCartItem> getItems(){
         return books.values();
    }

    /**
     * ���ع��ﳵ����Ʒ����������
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

    //��չ��ﳵ
    public void clear(){
        books.clear();
    }
    //�Ƴ�ָ���Ĺ�����
    public void removeItem(Integer id){
        books.remove(id);
    }

    //�޸�ָ�������������
    public void updateItemQuantity(int id,int quantity){
        ShoppingCartItem sci = books.get(id);
        if(sci != null){
            sci.setQuantity(quantity);
        }
    }

}
