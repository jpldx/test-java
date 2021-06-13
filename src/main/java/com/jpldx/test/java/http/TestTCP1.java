package com.jpldx.test.java.http;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Test TCP
 * @author chenxudong
 */
public class TestTCP1 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
             socket = new Socket("127.0.0.1", 8899);
             os = socket.getOutputStream();
             os.write("Hello socket ~!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try{
            ss = new ServerSocket(8899);
            socket = ss.accept();

            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());

            String srcHostname = socket.getInetAddress().getHostName();
            System.out.println("收到来自 " + srcHostname + "的信息。");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
