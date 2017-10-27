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

public class UpdateHeroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Connection c = null;
        HeroDAO heroDAO = new HeroDAO();
        try {
            c = heroDAO.getConnection();

            Hero hero = new Hero();
            hero.setName(request.getParameter("heroName"));
            hero.setHp(Float.parseFloat(request.getParameter("heroHp")));
            hero.setDamage(Integer.parseInt(request.getParameter("heroDamage")));
            hero.setId(Integer.parseInt(request.getParameter("id")));

            heroDAO.update(c,hero);

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
