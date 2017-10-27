package day02;

import java.sql.*;

/**
 * Created by garyhu
 * on 2017/9/21.
 * method: 预处理数据库操作
 */
public class PreSQL {
    public static void main(String[] args){
        PreparedStatement ps = null;
        Connection c  = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(
                   "jdbc:mysql://127.0.0.1:3306/myjava?characterEncoding=UTF-8",
                   "root","garyhu"
            );
            //执行插入预处理操作
            String str = "insert into hero values(null,?,?,?)";
            ps = c.prepareStatement(str);
            //设置参数
            ps.setString(1,"安妮");
            ps.setFloat(2,876);
            ps.setFloat(3,81);
            //执行
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)
                    ps.close();
                if(c!=null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
