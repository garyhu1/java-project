package filter;

import bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription :
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        if(uri.endsWith("login")||uri.endsWith("login.jsp")){
            chain.doFilter(req,resp);
            return;
        }

        User user = (User) req.getSession().getAttribute("user");
        if(user==null){
            resp.sendRedirect("/login.jsp");
            return;
        }

        chain.doFilter(req,resp);
    }

    public void destroy() {

    }
}
