package com.jpldx.inter;

/**
 * @author chen.xudong
 */
public interface A
{
    // 常量
    public static final int NUM=1;

    // 抽象方法
    public abstract void show();
}

interface B extends A{
    void eat();
}

class C implements B{
    @Override
    public void show() {

    }
    @Override
    public void eat() {

    }
}
