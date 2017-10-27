package servlet;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDao;
import dao.OrderItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription :
 */
@WebServlet(name = "CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = (User) req.getSession().getAttribute("user");
        if(u==null){
            resp.sendRedirect("/login.jsp");
            return;
        }

        Order o = new Order();
        o.setUser(u);

        new OrderDao().insert(o);

        List<OrderItem> items = (List<OrderItem>) req.getSession().getAttribute("items");
        for(OrderItem item : items){
            item.setOrder(o);
            new OrderItemDao().insert(item);
        }

        items.clear();

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("订单创建成功");
    }
}
