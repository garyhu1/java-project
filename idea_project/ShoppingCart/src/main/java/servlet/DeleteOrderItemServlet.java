package servlet;

import bean.OrderItem;

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
@WebServlet(name = "DeleteOrderItemServlet")
public class DeleteOrderItemServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid = Integer.parseInt(req.getParameter("pid"));
        List<OrderItem> items = (List<OrderItem>) req.getSession().getAttribute("items");
        for(OrderItem item: items){
            if(pid == item.getProduct().getId()){
                items.remove(item);
                break;
            }
        }

        resp.sendRedirect("/listOrderItem.jsp");
    }
}
