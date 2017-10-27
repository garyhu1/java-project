package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by garyhu
 * on 2017/9/15.
 * method: 数据库的练习
 */
public class TestJDBC {
    public static void main(String[] args){
        Connection c = null;
        Statement s = null;
        try {
            //首先加载数据库的驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
            //与现有的数据库创建连接
            /*
            * url：由localhost(127.0.0.1)+端口号(3306)+数据库名称(myjava)+编码格式(utf-8)
            * user: root
            * password: garyhu
            */
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/myjava?characterEncoding=UTF-8",
                    "root","garyhu");
            System.out.println("数据库连接成功： "+c);
            //获取Statement,用于执行SQL语句，比如增加、删除
            s = c.createStatement();
            System.out.println("获取Statement对象： "+s);
            //增加一条数据到数据库中
            String str = "insert into hero values(null,"+"'崔丝塔娜',"+768f+","+100f+")";
            s.execute(str);
            System.out.println("执行增加数据的操作成功");
            //删除一条数据
            String del = "delete from hero where id = 11";
            s.execute(del);
            //修改其中的一条数据
            String update = "update hero set name = '卡兹克',damage = 47 where id = 12";
            s.execute(update);
        } catch (ClassNotFoundException e) {
            System.out.println("this a ClassNotFoundException");
//            e.printStackTrace();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            //最后一定要关闭数据库，
            //先关闭Statement,再关闭Connection
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
