package com.jpldx.test.java.reflection2;

/**
 * @author chenxudong
 */
@MyAnnotation(value = "student")
public class Student extends Person<String> implements MyInterface {

    private String name;
    int age;
    public int id;

    public Student(){}

    private Student(String name){
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "showNation()")
    private String showNation(String nation){
        System.out.println("My nation is: " + nation);
        return nation;
    }

    @Override
    public void sayHello(String message) {
        System.out.println("Hello: " + message);
    }

    /**
     * static method
     */
    public static void showDesc(){
        System.out.println("No pain no gain ~!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
