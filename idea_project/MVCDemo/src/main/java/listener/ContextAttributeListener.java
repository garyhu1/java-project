package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription :
 */
public class ContextAttributeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent e) {
        //监听属性的增加
        System.out.println("增加属性");
        System.out.println("属性是："+e.getName());
        System.out.println("值是 ："+e.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent e) {
        //监听属性的移除
        System.out.println("移除属性");
    }

    public void attributeReplaced(ServletContextAttributeEvent e) {
        //监听属性的替换
        System.out.println("属性值替换");
    }
}
