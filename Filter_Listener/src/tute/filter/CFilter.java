package tute.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author:田增印
 * @Date:2019/10/13
 * @Time:14:14
 * @Description:${PACKAGE_NAME}
 * @VERSION:1.0
 */
@WebFilter(filterName = "CFilter")
public class CFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("C.....");
        chain.doFilter(req, resp);
        System.out.println(".....C");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
