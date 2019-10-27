package cn.edu.tute.dao;

import cn.edu.tute.domain.Product;

import java.util.List;

/**
 * @Author:田增印
 * @Date:2019/10/23
 * @Time:20:51
 * @Description:cn.edu.tute.dao.impl
 * @VERSION:1.0
 */
public interface IProductDAO {
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Integer id);
    Product get(Integer id);
    List<Product> list();
}
