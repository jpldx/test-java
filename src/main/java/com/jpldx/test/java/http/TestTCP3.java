package com.jpldx.test.java.http;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
* Test TCP
*
* @author chenxudong
*/
public class TestTCP3 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket("127.0.0.1", 9090);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("logo.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            // read()方法是阻塞式方法，数据传输完成后需要显式关闭数据的输出
            socket.shutdownOutput();

            // 2. 客户端响应
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = is.read(buffer1)) != -1){
                baos.write(buffer1,0,len1);
            }
            System.out.println("return: " + baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;

        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();

            is = socket.getInputStream();
            fos = new FileOutputStream(new File("logo_receive.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            // 1. 服务端反馈
            os = socket.getOutputStream();
            os.write("success !".getBytes());


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
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
