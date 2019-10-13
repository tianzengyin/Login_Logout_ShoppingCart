package tute.dao.impl;

import tute.dao.IUserDAO;
import tute.domain.User;
import tute.utils.JDBCUtils;

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
    public UserDAOImpl() {
    }

    @Override
    public User checkLogin(String username, String password) {
        if(username == null || password==null){
            return null;
        }
        User userRel = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user where username = ? and password = ?";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while( resultSet.next()){
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                if(user.equals(username)&&pass.equals(password)){
                    userRel.setUsername(user);
                    userRel.setPassword(pass);
                    return  userRel;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
        return null;
    }
}
