package com.jpldx.test.java.reflection2;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.TreeSet;

/**
 * @author chenxudong
 */
public class TestOther {

    @Test
    public void test(){
        Class clazz = Student.class;
        // 获取当前运行时类的父类
        Class superClass = clazz.getSuperclass();

// 获取当前运行时类的带泛型的父类
        Type genericSuperClass = clazz.getGenericSuperclass();

// 获取当前运行时类的带泛型的父类的泛型
        ParameterizedType paramType = (ParameterizedType) genericSuperClass; // 强转
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    @Test
    public void test2(){
        Class clazz = Student.class;
        // 获取当前运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();

// 获取当前运行时类父类实现的接口
        Class[] superclassInterfaces = clazz.getSuperclass().getInterfaces();
    }

    @Test
    public void test3() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Student> clazz = Student.class;

// 创建运行时类的对象
        Student student = clazz.newInstance();

// 获取指定的属性
        Field id = clazz.getField("id");

// 设置当前属性的值
// param1:指定设置哪个对象的属性
// param2:指定设置的属性值
        id.set(student,1001);

// 获取当前属性值
// param1:指定获取哪个对象的当前属性值
        int studentId = (int)id.get(student);
        System.out.println(studentId);
    }

    @Test
    public void test4() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Student> clazz = Student.class;

// 创建运行时类的对象
        Student student = clazz.newInstance();

// getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);

// 设置当前属性的值
// param1:指定设置哪个对象的属性
// param2:指定设置的属性值
        name.set(student,1001);

// 获取当前属性值
// param1:指定获取哪个对象的当前属性值
        String studentName = (String)name.get(student);
        System.out.println(studentName);
    }
    
    @Test
    public void test5() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Student> clazz = Student.class;
        Student student = clazz.newInstance();

// 获取指定的某个方法
// param1:指定方法名称
// param2:指定方法参数类型
        Method method = clazz.getDeclaredMethod("showNation", String.class);
        method.setAccessible(true);
        method.invoke(student, "China");


        System.out.println("****** Invoke static method ******");
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);
    }


    @Test
    public void test6() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> clazz = Student.class;
        Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class);

        // 保证此构造器是可访问的
        constructor.setAccessible(true);
        Student instance = constructor.newInstance("Tom");
        System.out.println(instance);
    }


}
