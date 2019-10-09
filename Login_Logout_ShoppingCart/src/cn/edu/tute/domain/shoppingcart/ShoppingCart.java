package cn.edu.tute.domain.shoppingcart;

import java.util.Iterator;
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
    //商品总价
    private Double totalPrice;

    //增加商品
    public void save(CartItem item){
        //如果要添加的商品在购物车中存在，就只修改它的的数量
        for (CartItem cartItem : items) {
            if(cartItem.getId().equals(item.getId()) ){
                cartItem.setNum(cartItem.getNum()+item.getNum());
                return;
            }
        }
        //反之，就要添加一个新的元素
        items.add(item);
    }

    /**
     * 删除商品
     */
    public void delete(Long id){
        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()){
            CartItem item = iterator.next();
            if(item.getId().equals(id) ){
                iterator.remove();
            }
        }
    }
    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    /**
     * 获取商品总价
     * @return
     */
    public Double getTotalPrice() {
        for (CartItem item : items) {
            totalPrice += item.getPrice() * item.getNum();
        }
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
