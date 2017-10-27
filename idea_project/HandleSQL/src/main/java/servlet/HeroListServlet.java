package servlet;

import bean.Hero;
import dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HeroListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        HeroDAO heroDAO = new HeroDAO();
        Connection c = null;
        try {
            c = heroDAO.getConnection();
            List<Hero> heros = heroDAO.list(c);

            StringBuffer sb = new StringBuffer();
            sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
            sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>edit</td><td>delete</td></tr>\r\n");

            String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='editHero?id=%d'>edit</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";

            for (Hero hero : heros) {
                String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage(),hero.getId(),hero.getId());
                sb.append(tr);
            }

            sb.append("</table>");

            resp.getWriter().write(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(c!=null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
