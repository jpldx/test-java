package com.jpldx.test.java.reflection1;

import org.junit.Test;

/**
 * @author chenxudong
 */
public class TestNewInstance {

   @Test
   public void test1() throws IllegalAccessException, InstantiationException {
       Class clazz = Person.class;
       Object o = clazz.newInstance();
       System.out.println(o);
   }
}
