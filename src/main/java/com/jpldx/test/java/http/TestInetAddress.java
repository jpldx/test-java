package com.jpldx.test.java.http;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author chenxudong
 */
public class TestInetAddress {

    @Test
    public void test1() throws UnknownHostException {
        InetAddress ia1 = InetAddress.getByName("192.168.113.54");
        System.out.println(ia1); // /192.168.113.54

        InetAddress ia2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ia2); // /192.168.113.54

        InetAddress ia3 = InetAddress.getByName("localhost");
        System.out.println(ia3);

        InetAddress ia4 = InetAddress.getLocalHost();
        System.out.println(ia4);

        System.out.println(ia2.getHostName());
        System.out.println(ia2.getHostAddress());
    }
}
