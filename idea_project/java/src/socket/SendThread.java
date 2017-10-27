package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by garyhu
 * on 2017/9/29.
 * method:
 */
public class SendThread implements Runnable{

    private Socket s;

    public SendThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(outputStream);
            while(true){
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
