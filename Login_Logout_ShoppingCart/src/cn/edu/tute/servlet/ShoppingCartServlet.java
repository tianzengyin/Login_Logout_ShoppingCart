package cn.edu.tute.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:田增印
 * @Date:2019/10/9
 * @Time:22:58
 * @Description:${PACKAGE_NAME}
 * @VERSION:1.0
 */
@WebServlet("/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接收请求参数
        //调用业务方法处理请求
        //控制页面跳转
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
