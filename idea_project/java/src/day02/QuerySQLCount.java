package day02;

import java.sql.*;

/**
 * Created by garyhu
 * on 2017/9/20.
 * method:
 */
public class QuerySQLCount {

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
            String str = "select count(*) from hero";
            ResultSet res = s.executeQuery(str);
            int total = 0;
            while(res.next()){
                total = res.getInt(1);
            }
            System.out.println("数据库总条数： "+total);
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
