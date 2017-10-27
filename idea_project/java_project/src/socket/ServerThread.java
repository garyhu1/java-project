package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method:
 */
public class ServerThread implements Runnable{

    private Socket client;

    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        if(client==null)
            return;
        PrintStream out = null;
        BufferedReader buf = null;
        try{
            //获取输出流，用来向客户端发送数据
            out = new PrintStream(client.getOutputStream());
            //获取socket的输入流，用来读取客户端发来的数据
            buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //定义一个标志，用来判断服务是否中断
            boolean flag = true;
            while(flag){
                String str = buf.readLine();
                if(str==null||"".equals(str)){
                    flag = false;
                }else {
                    if("bye".equals(str)){
                        flag = false;
                    }else {
                        //将客户端发送来的数据添加echo后发送给客户端，然后在客户端打印出来
                        out.println("echo: "+str);
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //关闭流，释放资源
            try {
                if(out!=null)
                    out.close();
                if(buf!=null)
                    buf.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
