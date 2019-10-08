package cn.edu.tute.dao;

import cn.edu.tute.domain.User;

/**
 * @Author:田增印
 * @Date:2019/9/28
 * @Time:21:36
 * @Description:cn.edu.tute.dao
 * @VERSION:1.0
 */
public interface IUserDAO {
    int insert(String userName,String userPwd);
    User selectByName(String userName);
}
