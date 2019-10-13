package tute.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther:田增印
 * @Date: 2019/6/1
 * @Description: JDBC工具类
 * @VERSION:1.0
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        //读取资源文件 获取值
        //1.创建Properties集合类
        Properties pro = new Properties();
        //2.加载文件
        try {
            //获取src路径下文件的方式--->ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            pro.load(new FileReader(path));
//            pro.load(new FileReader("D:\\ieda_workspace\\Java57WEB\\day05_JDBC\\src\\jdbc.properties"));
            //3.获取数据赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            //4.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if(null != stmt){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if(null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != stmt){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
