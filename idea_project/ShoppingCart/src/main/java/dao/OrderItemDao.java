package dao;

import bean.OrderItem;
import utils.CloseResUtil;

import java.sql.*;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription :
 */
public class OrderItemDao {

    public void insert(OrderItem item){
        Connection c = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","garyhu");
            String sql = "insert into orderitem values(null,?,?,?)";
            ps = c.prepareStatement(sql);

            ps.setInt(1,item.getProduct().getId());
            ps.setInt(2,item.getNum());
            ps.setInt(3,item.getOrder().getId());
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseResUtil.closeRes(c,ps);
        }
    }
}
