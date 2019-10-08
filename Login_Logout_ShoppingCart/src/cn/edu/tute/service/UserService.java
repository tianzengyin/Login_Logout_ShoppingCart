package cn.edu.tute.service;

/**
 * @Author:田增印
 * @Date:2019/10/8
 * @Time:14:43
 * @Description:cn.edu.tute.service
 * @VERSION:1.0
 */
public interface UserService {
    int insertUser(String userName,String userPwd,String userRePwd);
    int judgeLogin(String userName,String userPwd);
}
