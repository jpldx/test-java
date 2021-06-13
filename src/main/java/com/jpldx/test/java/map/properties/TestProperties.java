package com.jpldx.test.java.map.properties;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author chenxudong
 */
public class TestProperties {

    @Test
    public void test1() throws Exception {
        Properties pros = new Properties();
        pros.load(getClass().getResourceAsStream("test-pros.properties"));
        String name =  pros.getProperty("username");
        String password = pros.getProperty("password");
        System.out.println("username = " + name + ",password = " + password);
    }


    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        // 文件默认在当前module下
        pros.load(new FileInputStream("user.properties"));
        String name =  pros.getProperty("username");
        String password = pros.getProperty("password");
        System.out.println("username = " + name + ",password = " + password);
    }
}
