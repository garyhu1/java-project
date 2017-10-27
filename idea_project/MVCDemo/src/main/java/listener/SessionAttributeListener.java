package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("session 增加属性 ");
        System.out.println("属性是" + e.getName());
        System.out.println("值是" + e.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("session 增加移除 ");
    }

    public void attributeReplaced(HttpSessionBindingEvent e) {
        System.out.println("session 增加替换 ");
    }
}
