package servlet;

import bean.OrderItem;
import bean.Product;
import dao.ProductDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription :
 */
@WebServlet(name = "OrderItemAddServlet")
public class OrderItemAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int pid = Integer.parseInt(req.getParameter("pid"));
            int num = Integer.parseInt(req.getParameter("num"));

            Product product = new ProductDao().getProduct(pid);
            OrderItem item = new OrderItem();
            item.setNum(num);
            item.setProduct(product);
            List<OrderItem> items = (List<OrderItem>) req.getSession().getAttribute("items");
            if(items == null){
                items = new ArrayList<OrderItem>();
                req.getSession().setAttribute("items",items);
            }

            boolean isHas = false;
            for(OrderItem orderItem: items){
                if(orderItem.getProduct().getId()==item.getProduct().getId()){
                    orderItem.setNum(orderItem.getNum()+item.getNum());
                    isHas = true;
                    break;
                }
            }

            if(!isHas)
                items.add(item);
            resp.sendRedirect("/listOrderItem");
        }catch (NumberFormatException e){
            resp.sendRedirect("/listProduct");
        }
    }
}
