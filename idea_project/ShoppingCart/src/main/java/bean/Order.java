package bean;

/**
 * @Author : garyhu
 * @Since : 2017/10/19
 * @Decription : 订单类
 */
public class Order {

    int id;
    User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
