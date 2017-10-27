package dao;

import bean.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO {

    public HeroDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myjava?characterEncoding=UTF-8","root","garyhu");
    }

    /**
     *  获取数据个数
     * @param c 数据库连接
     * @return 数据数目
     */
    public int getTotal(Connection c){
        int total = 0;
        Statement s = null;
        try {
            s = c.createStatement();
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("total : "+total);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(s!=null){
                    s.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return total;
    }

    /**
     * 向数据库增加数据
     */
    public void add(Connection c, Hero hero){
        String sql = "insert into hero values(null,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1,hero.getName());
            ps.setFloat(2,hero.getHp());
            ps.setInt(3,hero.getDamage());

            ps.execute();

//            ResultSet rs = ps.getGeneratedKeys();
//            if(rs.next()){
//                int id = rs.getInt(1);
//                hero.setId(id);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 更新数据库
     */
    public void update(Connection c, Hero hero){
        String sql = "update hero set name = ?, hp = ?, damage = ? where id = ?";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1,hero.getName());
            ps.setFloat(2,hero.getHp());
            ps.setInt(3,hero.getDamage());
            ps.setInt(4,hero.getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 从数据库中删除数据
     */
    public void delete(Connection c,int id){
        Statement s = null;
        try {
            s = c.createStatement();
            String sql = "delete from hero where id = "+id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(s!=null)
                    s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取数据库中的数据
     */
    public Hero get(Connection c, int id){
        Hero hero = null;
        Statement s = null;
        try {
            s = c.createStatement();
            String sql = "select * from hero where id = "+id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.setId(id);
                hero.setName(name);
                hero.setDamage(damage);
                hero.setHp(hp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(s!=null)
                    s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hero;
    }

    /**
     * 分页查询
     */
    public List<Hero> list(Connection c, int start, int count){
        List<Hero> heros = new ArrayList<Hero>();
        PreparedStatement ps = null;
        String sql = "select * from hero order by id desc limit ?,?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,count);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Hero hero = new Hero();
                hero.setId(rs.getInt(1));
                hero.setName(rs.getString(2));
                hero.setHp(rs.getFloat("hp"));
                hero.setDamage(rs.getInt(4));

                heros.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return heros;
    }

    public List<Hero> list(Connection c){
        return list(c,0,Short.MAX_VALUE);
    }
}
