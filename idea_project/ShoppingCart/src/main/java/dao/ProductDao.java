package dao;

import bean.Product;
import utils.CloseResUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : garyhu
 * @Since : 2017/10/18
 * @Decription : 只操作产品数据库的查询工作
 */
public class ProductDao {

    public List<Product> query(){
        List<Product> products = new ArrayList<Product>();
        Connection c = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","garyhu");
            String sql = "select * from product order by id asc";
            ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product p = new Product();
                int id = rs.getInt(1);
                String name = rs.getString("name");
                float price = rs.getFloat(3);

                p.setId(id);
                p.setName(name);
                p.setPrice(price);
                products.add(p);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseResUtil.closeRes(c,ps);
        }
        return products;
    }

    public Product getProduct(int id){
        Product product = null;
        Connection c = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","garyhu");
            String sql = "select * from product where id = ?";
            ps = c.prepareStatement(sql);

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                product = new Product();
                String name = rs.getString("name");
                float price = rs.getFloat(3);

                product.setId(id);
                product.setName(name);
                product.setPrice(price);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseResUtil.closeRes(c,ps);
        }
        return product;
    }

}
