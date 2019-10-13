package tute.servlet;


import tute.domain.shoppingcart.CartItem;
import tute.domain.shoppingcart.ShoppingCart;

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
        String cmd = request.getParameter("cmd");
        if("save".equals(cmd) ){
            save(request,response);
        }else if("delete".equals(cmd) ){
            delete(request,response);
        }


    }

    /**
     *  保存
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shoppingName = request.getParameter("name");
        String num = request.getParameter("num");
        //调用业务方法处理请求
        //从session中取出购物车对象
        ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
        //如果为null,创建一个新的购物车，并且放到session中
        if(cart==null ){
            cart = new ShoppingCart();
            request.getSession().setAttribute("SHOPPINGCART_IN_SESSION",cart);
        }
        //封装商品的数据
        CartItem item = new CartItem();
        item.setName(shoppingName);
        item.setNum(Integer.parseInt(num));
        if("电脑".equals(shoppingName) ){
            item.setId(111L);
            item.setPrice(10000D);
        }
        if("手机".equals(shoppingName) ){
            item.setId(222L);
            item.setPrice(3000D);
        }
        if("IPAD".equals(shoppingName) ){
            item.setId(333L);
            item.setPrice(4000D);
        }
        cart.save(item);
        //控制页面跳转
        //response.sendRedirect("/shoppingcart/cart.jsp");
        request.getRequestDispatcher("/shoppingcart/cart.jsp").forward(request,response);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
        cart.delete(Long.valueOf(id));
        //response.sendRedirect(request.getContextPath()+"/shoppingcart/cart.jsp");
        request.getRequestDispatcher("/shoppingcart/cart.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
