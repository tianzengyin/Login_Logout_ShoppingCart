package cn.edu.tute.dao.impl;

import cn.edu.tute.dao.IProductDAO;
import cn.edu.tute.domain.Product;
import cn.edu.tute.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:田增印
 * @Date:2019/10/23
 * @Time:21:01
 * @Description:cn.edu.tute.dao.impl
 * @VERSION:1.0
 */
public class ProductDAOImpl implements IProductDAO{

    @Override
    public boolean save(Product product) {
        String sql = "INSERT into product (productName,dir_id,salePrice,supplier,brand,cutoff,costPrice) " +
                "values(?,?,?,?,?,?,?)" ;
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getDirId());
            preparedStatement.setDouble(3,product.getSalePrice());
            preparedStatement.setString(4,product.getSupplier());
            preparedStatement.setString(5,product.getBrand());
            preparedStatement.setDouble(6,product.getCutoff());
            preparedStatement.setDouble(7,product.getCostPrice());
            int i = preparedStatement.executeUpdate();
            if( i>0){
            return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement,connection);
        }
        return false;
    }

    @Override
    public boolean update(Product product) {

        String sql = "update product set productName = ? , dir_id = ? , salePrice = ? , supplier = ? ,brand = ? , cutoff = ?,costPrice = ? where id = ?" ;
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getDirId());
            preparedStatement.setDouble(3,product.getSalePrice());
            preparedStatement.setString(4,product.getSupplier());
            preparedStatement.setString(5,product.getBrand());
            preparedStatement.setDouble(6,product.getCutoff());
            preparedStatement.setDouble(7,product.getCostPrice());
            preparedStatement.setInt(8,product.getId());
            int i = preparedStatement.executeUpdate();
            System.out.println(sql);
            if(i>0 ){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement,connection);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id)  {
        String sql = "delete from product where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            if(i>0 ){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement,connection);
        }
        return false;
    }

    @Override
    public Product get(Integer id) {
        String sql = "select * from product where id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            conn = JDBCUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            Product product = null;
            if(resultSet.next()){
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("productName"));
                product.setDirId(resultSet.getInt("dir_id"));
                product.setBrand(resultSet.getString("brand"));
                product.setSupplier(resultSet.getString("supplier"));
                product.setCostPrice(resultSet.getDouble("costPrice"));
                product.setCutoff(resultSet.getDouble("cutoff"));
                product.setSalePrice(resultSet.getDouble("salePrice"));
                return  product;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,conn);
        }
        return null;
    }

    @Override
    public List<Product> list() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            conn = JDBCUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Product product = null;
            while (resultSet.next()){
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("productName"));
                product.setDirId(resultSet.getInt("dir_id"));
                product.setBrand(resultSet.getString("brand"));
                product.setSupplier(resultSet.getString("supplier"));
                product.setCostPrice(resultSet.getDouble("costPrice"));
                product.setCutoff(resultSet.getDouble("cutoff"));
                product.setSalePrice(resultSet.getDouble("salePrice"));
                list.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,conn);
        }
        return list;
    }
}
