package src;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by evenj on 2017/5/3.
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ine=InetAddress.getLocalHost();
        System.out.println(ine.getHostAddress());
        System.out.println(ine.getHostName());
    }
}
