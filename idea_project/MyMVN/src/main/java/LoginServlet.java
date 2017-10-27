import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
  Servlet是单例模式，所以LoginServlet构造函数只被调用一次
  方法执行顺序：先执行构造函数，再执行init()方法，再执行service()方法，最后执行销毁操作
 */
public class LoginServlet extends HttpServlet {

    public LoginServlet(){
        System.out.println("LoginServlet 构造方法 被调用");
    }

    //无论访问了多少次LoginSerlvet,init初始化 只会执行一次
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init(ServletConfig)");
    }

    //该函数用来判断是执行doGet()函数还是doPost()函数，也可以直接在该方法中执行一些逻辑操作，就不用再调用那两个函数了
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);//注释后，就不会执行父类的判断操作
        //自己写内部的逻辑操作
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //如果登录成功了，就服务端跳转到success.html
        //如果登录失败了，就客户端跳转到fail.html
        if("garyhu".equals(name)&&"123456".equals(password)){
            req.getRequestDispatcher("success.html").forward(req,resp);
        }else {
            resp.sendRedirect("fail.html");
        }
        System.out.println("service() --> "+req.getMethod());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String html ;
        if("123456".equals(password)){
            html = "<div style='width: 80px;height: 30px;color: darkgreen; margin: 50px auto'>登录成功</div>";
        }else {
            html = "<div style='width: 80px;height: 30px;color: red; margin: 50px auto'>登录失败</div>";
        }
        //设置响应格式和编码,发送到浏览器的内容用该编码，浏览器显示时也会用该编码
        response.setContentType("text/html; charset=UTF-8");
        //设置响应编码，发送到浏览器的内容使用该编码，显示只会取决于浏览器的编码格式，不会使用该编码
//        response.setCharacterEncoding("UTF-8");
        //这两种方式都需要在response.getWriter调用之前执行才能生效。
        response.getWriter().println(html);
    }

    //销毁
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy()");
    }
}
