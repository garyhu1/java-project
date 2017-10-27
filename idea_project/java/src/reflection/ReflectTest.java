package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by garyhu
 * on 2017/10/9.
 * method:
 */
public class ReflectTest {
    
    public static void main(String[] main){
        String className = "reflection.User";
        try {
            Class aClass = Class.forName(className);
            Constructor c = aClass.getConstructor();
            User user = (User)c.newInstance();
            user.setName("xiaoming");
            Field f = aClass.getDeclaredField("name");
            f.setAccessible(true);
            f.set(user,"jack");
            System.out.println("用户名："+user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
