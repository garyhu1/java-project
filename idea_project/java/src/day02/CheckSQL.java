package day02;

import java.sql.*;

/**
 * Created by garyhu
 * on 2017/9/18.
 * method: 检查数据库数据是否正确
 */
public class CheckSQL {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/myjava?characterEncoding=UTF-8",
                    "root", "garyhu"
            );
            s = c.createStatement();
            String name = "xiaoming";
            String password = "123456";
            String str = "select * from user where name = '"+name+"'and password = '"+password+"'";
            ResultSet res = s.executeQuery(str);
            if(res.next()){
                System.out.println("用户密码验证通过");
            }else {
                System.out.println("用户密码验证失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(s!=null)
                    s.close();
                if(c!=null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
