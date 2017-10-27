package reflection;

/**
 * Created by garyhu
 * on 2017/10/9.
 * method:
 */
public class User {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @SafeVarargs
    public static <T>T getT(T... params){
        return params.length>0?params[0]:null;
    }
}
