package socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method:
 */
public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8788);
        boolean flag = true;
        Socket s = null;
        while(flag){
            s = ss.accept();
            System.out.println("与客户端连接成功");
            Thread t = new Thread(new ServerThread(s));
            t.start();
        }
        if(s!=null)
            s.close();
        if(ss!=null)
            ss.close();
    }
}
