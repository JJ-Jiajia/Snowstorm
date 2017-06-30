package src;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by evenj on 2017/5/3.
 */
public class SocketDemo {
    public void server(){
        ServerSocket ss=null;
        Socket s=null;
        InputStream is=null;
        try {
            ss=new ServerSocket(9900);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s=ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is= s.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int len;
        byte[] b=new byte[20];
        try {
            while ((len=is.read())!=-1){
                System.out.print(new String(b,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
