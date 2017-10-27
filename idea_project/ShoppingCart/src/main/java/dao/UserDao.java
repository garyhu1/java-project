package dao;

import bean.User;
import utils.CloseResUtil;

import java.sql.*;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription : 用户统计的数据库
 */
public class UserDao {

    public User getUser(String name,String password){
        User user = null;
        Connection c = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","garyhu");
            String sql = "select * from user where name = ? and password = ?";
            ps = c.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                user = new User();
                int id = rs.getInt(1);

                user.setId(id);
                user.setName(name);
                user.setPassword(password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseResUtil.closeRes(c,ps);
        }
        return user;
    }

}
