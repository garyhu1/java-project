package day04;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by garyhu
 * on 2017/9/29.
 * method:
 */
public class CheckIP {

    public static void main(String[] args){
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ip = localHost.getHostAddress();
            System.out.println("本地IP : "+ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
