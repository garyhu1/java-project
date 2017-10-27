package servlet;

import bean.Product;
import dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
@WebServlet(name = "ProductListServlet")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> products = new ProductDao().query();

        req.setAttribute("products",products);

        req.getRequestDispatcher("listProduct.jsp").forward(req,resp);
    }
}
