package com.jpldx.test.java.http;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Test java.net.URL
 *
 * @author chenxudong
 */
public class TestURL {

    @Test
    public void test() throws IOException {

        URL url = new URL("http://docker.vm.com:8080/examples/avatar.jpg");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        connection.connect();
        InputStream is = connection.getInputStream();

        FileOutputStream fos = new FileOutputStream("avatar_url.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        fos.close();
        is.close();
        connection.disconnect();
    }
}
