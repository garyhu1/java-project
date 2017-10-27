package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener {
    public void attributeAdded(ServletRequestAttributeEvent e) {
        System.out.println("request 增加属性 ");
        System.out.println("属性是" + e.getName());
        System.out.println("值是" + e.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent e) {
        System.out.println("request 移除属性 ");
    }

    public void attributeReplaced(ServletRequestAttributeEvent e) {
        System.out.println("request 替换属性 ");
    }

    public void requestDestroyed(ServletRequestEvent e) {
        System.out.println("销毁一个 request ");
    }

    public void requestInitialized(ServletRequestEvent e) {
        System.out.println("初始化一个 request ");
    }
}
