package com.atguigu.bookstore.web;

import com.atguigu.bookstore.domain.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BookStoreWebUtils {
    /**
     * 从session中获取购物车对象，如果session中没有，那么就创建一个放入session中
     * @param request
     * @return
     */
    public static ShoppingCart getShoppingCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart)session.getAttribute("ShoppingCart");
        if(sc == null){
            sc = new ShoppingCart();
            session.setAttribute("ShoppingCart",sc);
        }
        return sc;
    }
}
