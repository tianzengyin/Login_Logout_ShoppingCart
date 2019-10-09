package cn.edu.tute.service.shoppingcart;

/**
 * @Author:田增印
 * @Date:2019/10/9
 * @Time:21:33
 * @Description:cn.edu.tute.service.shoppingcart 商品对象
 * @VERSION:1.0
 */
public class CartItem {
    private  Long id;
    private String name;
    private Double price;
    private Integer num;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
