package tute.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:田增印
 * @Date:2019/10/20
 * @Time:20:28
 * @Description:${PACKAGE_NAME}登录校验
 * @VERSION:1.0
 */
@WebFilter(filterName = "CheckLoginFilter")
public class CheckLoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);
        System.out.println("requestURI = " + requestURI);

        /*if(!(request.getContextPath()+"/").equals(requestURI)
                &&!(request.getContextPath()+"/login/login.jsp").equals(requestURI)
                &&!(request.getContextPath()+"/randomCode").equals(requestURI)
                &&!(request.getContextPath()+"/login.html").equals(requestURI)){
            //登录校验
            Object obj = request.getSession().getAttribute("USERNAME_IN_SESSION");
            if(obj ==null ){
                response.sendRedirect(request.getContextPath()+"/login/login.jsp");
                //request.getRequestDispatcher("/login/login.jsp").forward(request,response);
            }
        }*/
        Object obj = request.getSession().getAttribute("USERNAME_IN_SESSION");
        if(obj ==null ){
            response.sendRedirect(request.getContextPath()+"/login/login.jsp");
            //request.getRequestDispatcher("/login/login.jsp").forward(request,response);
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
