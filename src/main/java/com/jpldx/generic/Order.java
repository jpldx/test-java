package com.jpldx.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.xudong
 */
public class Order<T>
{
    private String orderId;
    private String orderName;
    private T t;
    private List<T> list=new ArrayList<>();

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void add(T t){
        this.list.add(t);
    }
    public <E> E getE(E e){
        return e;
    }
}

