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

public class AddHeroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Connection c = null;


        try {
            HeroDAO heroDAO = new HeroDAO();
            Hero hero = new Hero();

            hero.setName(request.getParameter("heroName"));
            hero.setHp(Float.parseFloat(request.getParameter("heroHp")));
//            hero.setHp(100.00f);
            hero.setDamage(Integer.parseInt(request.getParameter("heroDamage")));
//            hero.setDamage(563);
            c = heroDAO.getConnection();
            heroDAO.add(c,hero);

            response.sendRedirect("/listHero");
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
