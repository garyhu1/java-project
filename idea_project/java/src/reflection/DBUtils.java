package reflection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by garyhu
 * on 2017/10/9.
 * method:
 */
@MyConfig(ip="127.0.0.1",database = "myjava",encoding = "UTF-8",loginName = "root",password = "garyhu")
public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        MyConfig config = DBUtils.class.getAnnotation(MyConfig.class);

        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url,loginName,password);
    }

    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        System.out.println(c);
    }
}
