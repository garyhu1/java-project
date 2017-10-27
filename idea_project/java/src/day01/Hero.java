package day01;

/**
 * Created by garyhu
 * on 2017/9/14.
 * method:用于二叉树的对象
 */
public class Hero {

    public String name;
    public float hp;

    public int damage;

    public Hero() {

    }

    public Hero(String name) {

        this.name = name;
    }

    public String toString() {
        return String.format("[name:%s hp:%.0f]%n", name,hp);
    }
}
