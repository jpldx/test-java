package com.jpldx.test.java.reflection2;

import java.io.Serializable;

/**
 * @author chenxudong
 */
public class Person<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("人呼吸");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}
