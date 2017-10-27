package dao;

import bean.Order;
import bean.Product;
import utils.CloseResUtil;

import java.sql.*;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription : 订单数据库，进行插入操作
 */
public class OrderDao {

    public void insert(Order o){
        Connection c = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","garyhu");
            String sql = "insert into order_ values(null,?)";
            ps = c.prepareStatement(sql);

            ps.setInt(1,o.getUser().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                o.setId(id);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseResUtil.closeRes(c,ps);
        }
    }

}
