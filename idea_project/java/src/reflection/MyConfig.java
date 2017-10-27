package reflection;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Created by garyhu
 * on 2017/10/9.
 * method:
 */
// 元注解
@Target({METHOD,TYPE}) //这个注解表示可以用用在类/接口上，还可以用在方法上
@Retention(RetentionPolicy.RUNTIME) //表示这是一个运行时注解，即运行起来之后，才获取注解中的相关信息，而不像基本注解如@Override 那种不用运行，在编译时eclipse就可以进行
@Inherited //这个注解表示可以被子类继承
@Documented //表示当执行javadoc的时候，本注解会生成相关文档
public @interface MyConfig {
    String ip();
    int port() default 3306;
    String database();
    String encoding();
    String loginName();
    String password();
}
