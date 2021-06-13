package com.jpldx.test.java.reflection1;

import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * 获取Class实例的4种方式
 *
 * @author chenxudong
 */
public class TestReflection2 {

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
    }

    @Test
    public void test2(){
        Person person = new Person();
        Class clazz = person.getClass();
    }

    @Test
    public void test3() throws ClassNotFoundException {
        Class clazz = Class.forName("com.jpldx.test.java.reflection1.Person");
        System.out.println(clazz);
    }

    @Test
    public void test4() throws ClassNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz = classLoader.loadClass("com.jpldx.test.java.reflection1.Person");
        System.out.println(clazz);
    }

    @Test
    public void test5(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass() == b.getClass()); // => true
// 只要数组元素类型和纬度一样，就是同一个Class
    }
}
