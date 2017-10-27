package bean;

/**
 * @Author : garyhu
 * @Since : 2017/10/17
 * @Decription : JavaBean 测试EL
 */
public class Hero {
    public int id;
    public String name;
    public float hp;
    public int damage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
