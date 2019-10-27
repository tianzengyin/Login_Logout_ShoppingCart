package cn.edu.tute.test;

import cn.edu.tute.dao.IProductDAO;
import cn.edu.tute.dao.impl.ProductDAOImpl;
import cn.edu.tute.domain.Product;
import org.junit.Test;

import java.util.List;

/**
 * @Author:田增印
 * @Date:2019/10/23
 * @Time:21:09
 * @Description:cn.edu.tute.test
 * @VERSION:1.0
 */
public class ProductDAOTest {
    private IProductDAO dao = new ProductDAOImpl();
    @Test
    public void testSave(){

        Product product = dao.get(1);
        product.setSalePrice(80D);
        product.setBrand("技嘉");
        boolean save = dao.save(product);
        System.out.println("save = " + save);
    }
    @Test
    public void testUpdate(){
        Product product = dao.get(1);
        product.setDirId(1);
        product.setProductName("技嘉M333");
        product.setSalePrice(78D);
        product.setSupplier("京东");
        product.setBrand("技嘉");
        product.setCutoff(0.95D);
        product.setCostPrice(30D);
        boolean update = dao.update(product);
        System.out.println("update = " + update);

    }
    @Test
    public void testDelete(){
        for (int i = 5; i <12 ; i++) {
            dao.delete(i);
        }

    }
    @Test
    public void testGet(){
        Product product = dao.get(1);
        System.out.println(product.toString());
    }
    @Test
    public void testList(){
        List<Product> list = dao.list();
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }
}
