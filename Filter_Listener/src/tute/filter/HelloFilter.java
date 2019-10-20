package tute.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:田增印
 * @Date:2019/10/13
 * @Time:10:22
 * @Description:tute.filter
 * @VERSION:1.0
 */
public class HelloFilter implements Filter {
    private String encoding = null;
    private String contentType = null;
    private Boolean force = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("初始化过滤器");
        encoding = filterConfig.getInitParameter("encoding");
        contentType=filterConfig.getInitParameter("contentType");
        force = Boolean.valueOf(filterConfig.getInitParameter("force"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        HttpServletResponse response =(HttpServletResponse)servletResponse;
        //request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        //设置请求的编码，
        if(!encoding.isEmpty()&&force ){
            request.setCharacterEncoding(encoding);
            response.setContentType(contentType);
        }

        System.out.println("hello");
        filterChain.doFilter(request,response);//放行
    }
    /*public boolean hasLength(String value){
            return !value.isEmpty() && !"".equals(value.trim());
    }*/
    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}
