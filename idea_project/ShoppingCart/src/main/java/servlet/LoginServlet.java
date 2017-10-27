package servlet;

import bean.User;
import dao.UserDao;

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
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = new UserDao().getUser(name, password);
        if(user == null){
            resp.sendRedirect("/login.jsp");
        }else {
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/listProduct");
        }
    }
}
