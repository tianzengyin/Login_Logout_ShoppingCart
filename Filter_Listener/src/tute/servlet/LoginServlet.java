package tute.servlet;


import tute.dao.IUserDAO;
import tute.dao.impl.UserDAOImpl;
import tute.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:田增印
 * @Date:2019/10/8
 * @Time:14:56
 * @Description:${PACKAGE_NAME}
 * @VERSION:1.0
 */
@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //验证码校验
        String randomCode = request.getParameter("randomCode");//用户填写的验证码
        //获取session中的验证码
        String randomCode_in_session = (String)request.getSession().getAttribute("RANDOMCODE_IN_SESSION");
         //将用户填写的验证码和session中的作对比
        if( !randomCode_in_session.equals(randomCode)){
            request.setAttribute("errorCodeMsg","验证码错误");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
            return;
        }

        String userName = request.getParameter("username");
        String uesrPwd = request.getParameter("password");


        IUserDAO iUserDAO = new UserDAOImpl();
        User user = iUserDAO.checkLogin(userName, uesrPwd);

        if(null != user) {
            //将登录的用户信息放到session中
            request.getSession().setAttribute("USERNAME_IN_SESSION",user.getUsername());
            //request.getRequestDispatcher("/login/success.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/system/success.jsp");
        }else {
            request.setAttribute("errorPasswordMsg","用户名或密码错误");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
