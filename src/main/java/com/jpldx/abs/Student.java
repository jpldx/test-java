package com.jpldx.abs;

/**
 * @author chen.xudong
 */
public class Student extends Person
{
    @Override
    public void cal() {
       for(int i=0;i<10000000;i++){
           Math.sqrt(i);
       }
    }

    public static void main(String[] args) {
        Person s=new Student();
        s.showSpeedTime();
    }

}
abstract class Person{
    abstract void cal();

    // 显示cal()方法的花费时间
    void showSpeedTime(){
        long s=System.currentTimeMillis();
        this.cal();
        long e=System.currentTimeMillis();
        System.out.println(e-s);
    }
}
