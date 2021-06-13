package com.jpldx.test.java.reflection1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author chenxudong
 */
public class TestReflection1 {

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getDeclaredConstructor(String.class, int.class);
        Person person = cons.newInstance("Tom", 12);
        System.out.println(person);

        Field age = clazz.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person);

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        System.out.println("****** Private Structure ******");
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person person1 = cons1.newInstance("Jerry");
        System.out.println(person1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1,"Hanmeimei");
        System.out.println(person1);

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(person1, "China");
        System.out.println("Return nation: " + nation);

    }
}
