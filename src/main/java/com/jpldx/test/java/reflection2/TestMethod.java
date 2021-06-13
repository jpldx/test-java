package com.jpldx.test.java.reflection2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author chenxudong
 */
public class TestMethod {

    @Test
    public void test1(){
        Class clazz = Student.class;

        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            String modifier = Modifier.toString(method.getModifiers());
        }
    }
}
