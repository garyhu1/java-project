package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription :
 */
public class CloseResUtil {

    public static void closeRes(Connection c, PreparedStatement ps){
        try {
            if(ps!=null){
                ps.close();
            }
            if(c!=null){
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
