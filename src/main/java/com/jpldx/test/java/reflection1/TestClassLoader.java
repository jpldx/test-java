package com.jpldx.test.java.reflection1;

import org.junit.Test;

/**
 * Test ClassLoader
 *
 * @author chenxudong
 */
public class TestClassLoader {


    @Test
    public void test1(){
        // 获取当前类的类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(classLoader);

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
