package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription :
 */
@WebServlet(name = "OrderItemListServlet")
public class OrderItemListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("listOrderItem.jsp").forward(req,resp);
    }
}
