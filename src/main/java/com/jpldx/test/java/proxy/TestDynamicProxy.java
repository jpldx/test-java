package com.jpldx.test.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Test dynamic proxy (动态代理)
 *
 * @author chenxudong
 */
public class TestDynamicProxy {

    public static void main(String[] args) {
        // 创建被代理类的对象
        Superman superman = new Superman();
        // 获取代理类的对象
        Human human = (Human)ProxyFactory.getProxyInstance(superman);
        // 调用代理类对象的方法 => 即调用被代理类对应的方法
        System.out.println(human.getBelief());
        human.eat("Noddles");
    }
}

// 被代理类
class Superman implements Human{

    @Override
    public String getBelief() {
        return "World Peace!";
    }

    @Override
    public void eat(String food) {
        System.out.println("Superman eat: " + food);
    }
}

class ProxyFactory{
    // 调用此方法，返回一个代理类的对象
    public static Object getProxyInstance(Object object){ // object:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                handler);
    }

}

class MyInvocationHandler implements InvocationHandler{

    private Object object; // 需要使用被代理类的对象进行赋值

    public void bind(Object object){
        this.object = object;
    }

   /*
    * 当通过代理类的对象调用方法foo()时，就会自动调用如下方法：invoke()
    * 将被代理类要执行的方法foo()的功能声明在invoke()中
    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method: 即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        // obj: 被代理类的对象

        // Like: pre-processor
        HumanUtils.method1();

        Object returnValue = method.invoke(object,args);

        // Like: post-processor
        HumanUtils.method2();

        return returnValue;
    }
}

interface Human{

    String getBelief();

    void eat(String food);
}

class HumanUtils{
    public static void method1(){
        System.out.println("====== Common method1 ======");
    }

    public static void method2(){
        System.out.println("====== Common method2 ======");
    }
}
