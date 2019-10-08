package cn.edu.tute.servlet;

import cn.edu.tute.service.UserService;
import cn.edu.tute.service.impl.UserServiceImpl;

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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("username");
        String uesrPwd = request.getParameter("password");

        int k = userService.judgeLogin(userName,uesrPwd);
        if(k > 0) {
            //将登录的用户信息放到session中
            request.getSession().setAttribute("USER_IN_SESSION",userName);
            request.getRequestDispatcher("/login/success.jsp").forward(request,response);

        }else {
            request.setAttribute("errorMsg","用户名或密码错误");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
