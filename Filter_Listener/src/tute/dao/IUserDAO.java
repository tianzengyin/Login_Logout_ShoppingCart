package tute.dao;

import tute.domain.User;

/**
 * @Author:田增印
 * @Date:2019/9/28
 * @Time:21:36
 * @Description:cn.edu.tute.dao
 * @VERSION:1.0
 */
public interface IUserDAO {
    User checkLogin(String username, String password);
}
