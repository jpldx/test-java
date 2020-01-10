package com.jpldx.reflect;

import lombok.Data;

/**
 * @author chen.xudong
 * @date 2020/1/10
 */
@Data
public class Person
{
    public String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("I am a person!");
    }

    public void display(String nationality) {
        System.out.println("My nationality is " + nationality);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
