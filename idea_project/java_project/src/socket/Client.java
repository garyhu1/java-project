package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method:
 */
public class Client {
    public static void main(String[] args) throws IOException{
        //创建客户端(ip地址要自己更新)
        Socket client = new Socket("192.168.1.105",8788);
        //设置请求超时时间为10s
        client.setSoTimeout(10000);
        //获取键盘输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //获取Socket的输出流，用来发送数据到服务端
        PrintStream out = new PrintStream(client.getOutputStream());
        //获取Socket的输入流，用来接收服务端发来的数据
        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //定义一个标志，用来判断服务连接是否结束
        boolean flag = true;
        while(flag){
            System.out.println("请输入信息：");
            //获取写入的信息
            String str = input.readLine();
            //把写入的信息发送到服务端
            out.println(str);
            //如果写入的内容是"bye"结束连接
            if("bye".equals(str)){
                flag = false;
            }else {
                try {
                    String echo = buf.readLine();
                    System.out.println(echo);
                }catch (SocketTimeoutException e){
                    System.out.println("Time Out, No response");
                }
            }
        }

        //关闭键盘输入流
        if(input!=null)
            input.close();
        //关闭流套接字，只要关闭套接字就会关闭相关的流
        if(client!=null)
            client.close();
    }
}
