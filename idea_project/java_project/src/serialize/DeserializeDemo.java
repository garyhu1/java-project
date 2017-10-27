package serialize;

import bean.Human;

import java.io.*;

/**
 * Created by garyhu
 * on 2017/9/5.
 * method: 反序列化的过程测试
 */
public class DeserializeDemo {
    public static void main(String[] args){
        String fileName = "E:/demo/human.ser";
        Human man = null;
        InputStream in = null;
        ObjectInputStream ois = null;
        try {
            in = new FileInputStream(fileName);
            ois = new ObjectInputStream(in);
            man = (Human)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(in!=null)
                    in.close();
                if(ois!=null)
                    ois.close();
                if(man!=null){
                    System.out.println("姓名： "+man.getName()+";\n生日： "+man.getBirth()+";\n年龄： "+man.getAge()+"\nID: "+man.getID());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
