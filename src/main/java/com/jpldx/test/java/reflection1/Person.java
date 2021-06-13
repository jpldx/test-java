package com.jpldx.test.java.reflection1;

/**
 * @author chenxudong
 */
public class Person {

    // private properties
    private String name;
    public int age;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // private contructor
    private Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("I am a person.");
    }

    // private method
    private String showNation(String nation){
        System.out.println("My nation is: " + nation);
        return nation;
    }
}
