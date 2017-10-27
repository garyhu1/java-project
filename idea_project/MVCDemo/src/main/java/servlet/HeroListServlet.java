package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author : garyhu
 * @Since : 2017/10/17
 * @Decription :
 */
@WebServlet(name = "HeroListServlet")
public class HeroListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先判断登录状态
        String userName = ((String) req.getSession().getAttribute("userName"));
        if(userName==null){
            resp.sendRedirect("login.html");
            return;
        }

        Connection c = null;
        HeroDAO heroDAO = new HeroDAO();
        try {
            c = heroDAO.getConnection();
            int total = heroDAO.getTotal(c);
            int start= 0;
            int count = 4;
            try{
                start = Integer.parseInt(req.getParameter("start"));
            }catch (NumberFormatException e){
                //没有下一页
            }
            int next = start + count;
            int pre = start - count;
            pre = pre>0?pre:0;
            int last = total-total%count;
            next = next>last?last:next;
            List<Hero> heros = heroDAO.list(c,start,count);

            req.setAttribute("heros",heros);
            req.setAttribute("next",next);
            req.setAttribute("pre",pre);
            req.setAttribute("last",last);

            req.getRequestDispatcher("jsp/listHero.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(c!=null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
