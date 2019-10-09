package cn.edu.tute.service.shoppingcart;

import java.util.List;

/**
 * @Author:田增印
 * @Date:2019/10/9
 * @Time:21:39
 * @Description:cn.edu.tute.service.shoppingcart
 * @VERSION:1.0
 * 购物车对象
 */
public class ShoppingCart {
    private  List<CartItem> items;
    private Double totalPrice;

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
