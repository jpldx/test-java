package com.jpldx.test.java.reflection2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author chenxudong
 */
public class TestField {

    @Test
    public void test1(){
        Class<Student> clazz = Student.class;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            String fieldName = field.getName();
            int modifier = field.getModifiers();
            Class type = field.getType();
            System.out.println(
                    "fieldName:" + fieldName +
                    "\tmodifier:" + Modifier.toString(modifier) +
                    "\ttype:" + type.getName());
        }
    }
}
