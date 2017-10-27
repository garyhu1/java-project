package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("web 应用开始初始化");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("web 应用开始销毁");
    }
}
