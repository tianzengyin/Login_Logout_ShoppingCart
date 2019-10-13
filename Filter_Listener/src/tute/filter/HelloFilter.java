package tute.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author:田增印
 * @Date:2019/10/13
 * @Time:10:22
 * @Description:tute.filter
 * @VERSION:1.0
 */
public class HelloFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hello");
        filterChain.doFilter(servletRequest,servletResponse);//放行
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}
