package cn.edu.tute.servlet;

import cn.edu.tute.dao.IProductDAO;
import cn.edu.tute.dao.impl.ProductDAOImpl;
import cn.edu.tute.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:田增印
 * @Date:2019/10/24
 * @Time:21:37
 * @Description:${PACKAGE_NAME}
 * @VERSION:1.0
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private IProductDAO dao;
    Integer id = null;
    Product productId = new Product();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cmd = request.getParameter("cmd");
        if("edit".equals(cmd)||"delete".equals(cmd) ){
            id = Integer.parseInt(request.getParameter("id"));
        }
        if("edit".equals(cmd) ||"add".equals(cmd) ){
            this.edit(request,response);
        }
        if("list".equals(cmd) ){
            this.list(request,response);
        }
        if("delete".equals(cmd) ){
            this.delete(request,response);
        }
        if("save".equals(cmd) ){
            this.saveOrUpdate(request,response);
        }
    }

    /**
     * 显示商品列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("list");
        //1.接收请求参数，封装成对象
        //2.调用业务请求处理请求
        List<Product> list = dao.list();
        //3.控制界面跳转
        request.setAttribute("PRODUCTS",list);
        request.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(request,response);
    }

    /**
     * 删除指定商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("delete");
        dao.delete(id);
        request.getRequestDispatcher("/product?cmd=list").forward(request,response);
    }

    /**
     * 进入编辑界面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("edit");
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        if(id!=null){
            productId = dao.get(id);
            request.setAttribute("product",productId);
        }
        //response.sendRedirect(request.getContextPath()+"/WEB-INF/views/product/edit.jsp");
        request.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(request,response);
    }

    /**
     * 新增或修改商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("save");
        System.out.println(id);
        Product product = new Product();
        dao = new ProductDAOImpl();
        if(id!=null ){
             this.requestToProduct(request,productId);
             boolean update = dao.update(productId);
             id = null;
        }else {
            this.requestToProduct(request,product);
            dao.save(product);
        }
        request.getRequestDispatcher("/product?cmd=list").forward(request,response);
    }

    private void requestToProduct(HttpServletRequest request, Product product) {
        String productName = request.getParameter("productName");
        Integer dirId = Integer.valueOf(request.getParameter("dir"));
        System.out.println(dirId);
        Double salePrice = Double.valueOf(request.getParameter("salePrice"));
        String supplier = request.getParameter("supplier");
        String brand = request.getParameter("brand");
        Double cutoff = Double.valueOf(request.getParameter("cutoff"));
        Double costPrice = Double.valueOf(request.getParameter("costPrice"));

        product.setProductName(productName);
        product.setDirId(dirId);
        product.setSalePrice(salePrice);
        product.setSupplier(supplier);
        product.setBrand(brand);
        product.setCutoff(cutoff);
        product.setCostPrice(costPrice);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ProductDAOImpl();
    }
}
