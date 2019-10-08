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
 * @Time:18:23
 * @Description:${PACKAGE_NAME}
 * @VERSION:1.0
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userRePwd = request.getParameter("userRePwd");

        int k = userService.insertUser(userName,userPwd,userRePwd);

        if(k > 0) {
            response.getWriter().write("注册成功");
        }else {
            response.getWriter().write("注册失败");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
