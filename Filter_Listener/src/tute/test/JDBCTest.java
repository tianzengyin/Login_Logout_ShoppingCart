package tute.test;

import org.junit.Test;
import tute.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @Author:田增印
 * @Date:2019/10/7
 * @Time:22:05
 * @Description:cn.edu.tute.test
 * @VERSION:1.0
 */
public class JDBCTest {
    @Test
    public void TestGetConnection(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);
    }
}
