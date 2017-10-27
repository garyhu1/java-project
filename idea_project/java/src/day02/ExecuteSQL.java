package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by garyhu
 * on 2017/9/21.
 * method: 测试execute与executeUpdate的区别
 */
public class ExecuteSQL {
    /*
     * 相同点：
     * execute与executeUpdate的相同点：都可以执行增加，删除，修改
     *
     * 不同1：
     * execute可以执行查询语句
     * 然后通过getResultSet，把结果集取出来
     * executeUpdate不能执行查询语句
     * 不同2:
     * execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
     * executeUpdate返回的是int，表示有多少条数据受到了影响
     *
     */
    public static void main(String[] args){
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/myjava?characterEncoding=UTF-8",
                    "root","garyhu"
            );
            String str = "update hero set name = 盖伦 where id = 12";
            s = c.createStatement();
            s.executeQuery(str);
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
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
