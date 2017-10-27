package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println("监听到 session 创建, sessionid 是： " + e.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent e) {
        System.out.println("监听到 session 销毁, sessionid 是： " + e.getSession().getId());
    }
}
