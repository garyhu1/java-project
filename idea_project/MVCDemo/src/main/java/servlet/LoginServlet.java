package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if("garyhu".equals(name)&&"123456".equals(password)){
            req.getSession().setAttribute("userName",name);
            resp.sendRedirect("heroList");
        }else {
            resp.sendRedirect("login.html");
        }
    }
}
