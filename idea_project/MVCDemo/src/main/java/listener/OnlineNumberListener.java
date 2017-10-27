package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
public class OnlineNumberListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent e) {
        ServletContext application = e.getSession().getServletContext();
        Integer onlineNum = (Integer) application.getAttribute("online-number");

        if(onlineNum == null){
            onlineNum = 0;
        }
        onlineNum++;
        application.setAttribute("online-number",onlineNum);

        System.out.println("新增一位在线用户"+onlineNum);
    }

    public void sessionDestroyed(HttpSessionEvent e) {
        ServletContext application = e.getSession().getServletContext();
        Integer onlineNum = (Integer) application.getAttribute("online-number");
        if(onlineNum==null){
            onlineNum = 0;
        }else {
            onlineNum--;
        }
        application.setAttribute("online-number",onlineNum);

        System.out.println("一位用户离线");
    }
}
