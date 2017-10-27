package serialize;

import bean.Human;

import java.io.*;

/**
 * Created by garyhu
 * on 2017/9/5.
 * method: 对象序列化的测试
 */
public class SerializeDemo {
    public static void main(String[] args){
        Human man = new Human("xiaoming","1999.11.19",18,1101);
        String fileName = "E:/demo/human.ser";

        OutputStream out = null;
        ObjectOutputStream oos = null;
        try {
            out = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(out);
            oos.writeObject(man);
            System.out.println("Serialized data is saved in E:/demo/human.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out!=null)
                    out.close();
                if(oos!=null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
