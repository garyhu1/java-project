package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by garyhu
 * on 2017/9/29.
 * method:
 */
public class RecieveThread implements Runnable {

    private Socket s;

    public RecieveThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try{
            InputStream in = s.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            while(true){
                String s = dis.readUTF();
                System.out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
