package cn.edu.tute.dao;

import cn.edu.tute.domain.User;
import cn.edu.tute.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author:田增印
 * @Date:2019/9/29
 * @Time:13:47
 * @Description:cn.edu.tute.dao.emol
 * @VERSION:1.0
 */
public class UserDAOImpl implements IUserDAO {
    Connection con = null;
    PreparedStatement pt = null;
    ResultSet rs = null;
    String sql;

    public UserDAOImpl() {
    }

    @Override
    public int insert(String userName, String userPwd) {
        int k = 0;
        sql = "insert into user value(null,?,?)";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, userName);
            pt.setString(2, userPwd);
            k = pt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            }finally {
            ConnectionUtil.closeRe(con,pt);
             }
             return k;
    }

    @Override
    public User selectByName(String userName) {
        sql = "select * from user where username = ?";
        User user = new User();
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, userName);
            rs = pt.executeQuery();

             while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                       }
               } catch (SQLException e) {
                 // TODO Auto-generated catch block
               e.printStackTrace();
                }finally {
                 ConnectionUtil.closeRe(con, pt, rs);
               }
              return user;

    }
}
