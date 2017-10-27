package day03;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by garyhu
 * on 2017/9/29.
 * method:
 */
public class TestGUI {

    public static void main(String[] args){
        JFrame jf = new JFrame("LOL");
        jf.setSize(400,300);
        jf.setLocation(200,200);
        jf.setLayout(null);
        JButton jb = new JButton("确定");
        jb.setText("Confirm");
        jb.setBounds(50,50,280,30);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
            }
        });
        jf.add(jb);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
