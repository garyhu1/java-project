package day02;

import java.sql.*;

/**
 * Created by garyhu
 * on 2017/9/15.
 * method:
 */
public class QuerySQL {

    public static void main(String[] args){
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/myjava?characterEncoding=UTF-8",
                    "root","garyhu"
            );
            s = c.createStatement();
            //查询数据库
            String str = "select * from hero";
            ResultSet res = s.executeQuery(str);
            while(res.next()){
                int id = res.getInt("id");//可以使用字段的名字来获取值
                String name = res.getString(2);//也可以使用字段的写入顺序来获取值
                float hp = res.getFloat("hp");
                float damage = res.getFloat(4);
                System.out.println("id = "+id+", name = "+name+", damage = "+damage+", hp = "+hp);
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
