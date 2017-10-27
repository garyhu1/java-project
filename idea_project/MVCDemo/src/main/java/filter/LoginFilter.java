package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();

        if(uri.endsWith("login")||uri.endsWith("login.html")){
            filterChain.doFilter(req,resp);
            return;
        }

        String userName = (String) req.getSession().getAttribute("userName");
        if(userName == null){
            resp.sendRedirect("login.html");
            return;
        }

        filterChain.doFilter(req,resp);
    }

    public void destroy() {

    }
}
