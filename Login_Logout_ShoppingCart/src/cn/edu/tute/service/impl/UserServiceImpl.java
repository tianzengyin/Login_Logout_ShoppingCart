package cn.edu.tute.service.impl;

import cn.edu.tute.dao.IUserDAO;
import cn.edu.tute.dao.UserDAOImpl;
import cn.edu.tute.domain.User;
import cn.edu.tute.service.UserService;
/**
 * @Author:田增印
 * @Date:2019/10/8
 * @Time:14:44
 * @Description:cn.edu.tute.service.impl
 * @VERSION:1.0
 */
public class UserServiceImpl implements UserService {
    IUserDAO userDao = new UserDAOImpl();
    @Override
    public int insertUser(String userName, String userPwd, String userRePwd) {
        int k = 0;
        if(userName == "" || userName == null || userPwd == "" || userRePwd == null) {
            return k;
        }
        if(!userPwd.equals(userRePwd)) {
            return k;
        }

        k = userDao.insert(userName,userPwd);

        return k;
    }

    @Override
    public int judgeLogin(String userName, String userPwd) {
        int k = 0;
        if(userName == "" || userName == null || userPwd == ""|| userPwd == null) {
            return k;
        }
        User user = userDao.selectByName(userName);

        if(!userPwd.equals(user.getPassword())) {
            k = 0;
        }else {
            k = 1;
        }
        return k;
    }
}
