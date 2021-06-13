package com.jpldx.test.java.http;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author chenxudong
 */
public class TestUDP1 {


    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        byte[] data = "Hello UDP ~!".getBytes();
        DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getLocalHost(),9090);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
