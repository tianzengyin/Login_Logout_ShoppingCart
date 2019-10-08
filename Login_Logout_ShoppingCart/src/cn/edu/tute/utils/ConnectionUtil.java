package cn.edu.tute.utils;

import java.sql.*;

/**
 * @Author:田增印
 * @Date:2019/10/8
 * @Time:14:33
 * @Description:cn.edu.tute.utils
 * @VERSION:1.0
 */
public class ConnectionUtil {
    private static String url = "jdbc:mysql://localhost:3306/db2";
    private static String rootName = "root";
    private static String rootPwd = "tzy241986";

    private ConnectionUtil() {};

    static {
        try {
            /*加载驱动*/
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * getConnection:创建连接.<br/>
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,rootName,rootPwd);
    }

    /**
     * closeRe:关闭连接.<br/>
     * @param con
     * @param pt
     * @param rs
     */
    public static void closeRe(Connection con, PreparedStatement pt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                if(pt != null) {
                    try {
                        pt.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally{
                        if(con != null) {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * closeRe:关闭连接.<br/>
     * @param con
     * @param pt
     */
    public static void closeRe(Connection con,PreparedStatement pt) {
        if(pt != null) {
            try {
                pt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                if(con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
