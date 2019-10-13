package tute.test;


import org.junit.Test;
import tute.dao.IUserDAO;
import tute.dao.impl.UserDAOImpl;
import tute.domain.User;

/**
 * @Author:田增印
 * @Date:2019/9/29
 * @Time:13:48
 * @Description:cn.edu.tute.test
 * @VERSION:1.0
 */
public class UserDAOTest {
    private IUserDAO dao = new UserDAOImpl();
    @Test
    public void testCheckLogin(){
        IUserDAO iUserDAO = new UserDAOImpl();
        User user = iUserDAO.checkLogin("zhangsan", "123");
        System.out.println(user.getUsername()+user.getPassword());
    }
}
