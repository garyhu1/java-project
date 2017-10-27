package bean;

import java.io.Serializable;

public class Human implements Serializable {

    private String name;
    private String birth;
    private int age;
    private int ID;

    public Human(String name, String birth, int age, int ID) {
        this.name = name;
        this.birth = birth;
        this.age = age;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
