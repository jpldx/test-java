package com.jpldx.abs;

/**
 * @author chen.xudong
 */
public class TestProxy
{
    public static void main(String[] args) {
        Object ob=new ProxyObject();
        ob.action();
    }
}

class ProxyObject implements Object{
    private Object obj;
    ProxyObject(){
        obj=new ObjectImpl();
        System.out.println("代理类创建成功！");
    }
    @Override
    public void action() {
        System.out.println("代理类开始执行...");
        obj.action();
        System.out.println("代理类执行结束...");
    }
}

interface Object{
    void action();
}
class ObjectImpl implements Object{
    @Override
    public void action() {
        System.out.println("===被代理类开始执行===");
        System.out.println("===被代理类执行结束===");
    }
}
