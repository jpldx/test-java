package com.jpldx.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chen.xudong
 * @date 2020/1/10
 */
public class TestReflection
{

    /**
     * 不使用反射
     */
    @Test
    public void test1(){
        Person person=new Person();
        person.setName("chenxudong");
        person.setAge(18);
        System.out.println(person);
        person.show();
        person.display("China");
    }

    /**
     * 使用反射
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Class clazz=Person.class;
        // 反射创建类的对象
        Person person=(Person)clazz.newInstance();
        // 反射调用类的属性 public
        Field nameField = clazz.getField("name");
        nameField.set(person,"xiaoyumiao");
        System.out.println(person);
        // private
        Field ageField=clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person,20);
        System.out.println(person);

        // 反射调用类的方法
        Method method1=clazz.getMethod("show");
        method1.invoke(person);

        Method method2=clazz.getMethod("display",String.class);
        method2.invoke(person,"America");
    }
}
