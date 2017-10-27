package day03;

import javax.swing.*;
import java.awt.*;

/**
 * Created by garyhu
 * on 2017/9/29.
 * method:
 */
public class InputTest {

    public static void main(String[] args){
        JFrame jf = new JFrame("用户登录");
        jf.setSize(800,300);
        jf.setLocation(500,300);
        jf.setLayout(new FlowLayout());
        JLabel jLName = new JLabel("用户名 ：");
        JTextField jTName = new JTextField("");
        jTName.setText("请输入用户名");
        jTName.setPreferredSize(new Dimension(80,30));
        JLabel jLPass = new JLabel("验证码 ：");
        JTextField jTPass = new JTextField("");
        jTPass.setText("请输入验证码");
        jTPass.setPreferredSize(new Dimension(80,30));
        JPasswordField js = new JPasswordField("");
        js.setPreferredSize(new Dimension(60,30));
        jf.add(jLName);
        jf.add(jTName);
        jf.add(jLPass);
        jf.add(jTPass);
        jf.add(js);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
