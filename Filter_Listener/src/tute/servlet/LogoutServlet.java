package tute.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:田增印
 * @Date:2019/10/8
 * @Time:20:25
 * @Description:${PACKAGE_NAME}
 * @VERSION:1.0
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁session对象
        //request.getSession().setAttribute("USER_IN_SESSION",null);
        request.getSession().invalidate();
        //回到登录页面
        response.sendRedirect("login/login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
