package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by garyhu
 * on 2017/9/29.
 * method: 数据库连接池
 */
public class ConnectionPool {

    private int size;
    private List<Connection> cs;

    public ConnectionPool(int size){
        this.size = size;
        cs = new ArrayList<>();
        init();
    }

    /**
     * 初始化数据库连接池
     */
    protected void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/myjava?characterEncoding=UTF-8",
                        "root","garyhu"
                );
                cs.add(c);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection(){
        while(cs.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }

    public synchronized void receiveConnection(Connection c){
        cs.add(c);
        this.notifyAll();
    }
}
