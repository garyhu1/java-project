package com.garyhu.test;

import com.garyhu.bean.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author : garyhu
 * @Since : 2017/10/23
 * @Decription :
 */
public class TestSpring {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"src/applicationContext.xml"}
        );

        Product p = (Product) context.getBean("p");
        System.out.println("产品名称： "+p.getName());
    }
}
