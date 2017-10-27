package day01;

import java.io.File;
import java.io.IOException;

/**
 * Created by garyhu
 * on 2017/9/14.
 * method: 从文件的操作开始
 */
public class FileDemo {
    public static void main(String[] args){
        File file = new File("E://demo/lol.txt");
        System.out.println("文件是否存在： "+file.exists());
        //文件重命名
        File f = new File("E://demo/file.txt");
        file.renameTo(f);
        System.out.println("获取文件所在的文件夹："+file.getParent());

        //创建新文件
        File f1 = new File("E://demo/test/study.ser");
        //如果父目录不存在就会报错,所以要先判断
        File dir = f1.getParentFile();
        if(!dir.exists()){
            dir.mkdir();
        }
        try {
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //删除文件
        File f2 = new File("E://demo/test/study.ser");
        f2.delete();
        //JVM结束的时候，刪除文件，常用于临时文件的删除
        f2.deleteOnExit();

    }
}
