package cn.edu.tute.test;

import cn.edu.tute.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author:田增印
 * @Date:2019/10/23
 * @Time:14:08
 * @Description:cn.edu.tute.test
 * @VERSION:1.0
 */
public class DruidTest {
    @Test
   public void  GetConnectionTest(){
        try {
            Connection connection = JDBCUtils.getConnection();
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
