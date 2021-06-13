package com.jpldx.test.java.proxy;

/**
 * Test static proxy (静态代理)
 * 代理类和被代理类在编译期间就确定下来了
 *
 * @author chenxudong
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        // 创建被代理类对象
        NikeClothesFactory nike = new NikeClothesFactory();

        // 创建代理类对象
        ProxyClothesFactory proxyClothesFactory = new ProxyClothesFactory(nike);

        // 调用代理方法
        proxyClothesFactory.produceClothes();
    }

}

// 代理类
class ProxyClothesFactory implements ClothesFactory {

    private final ClothesFactory factory;

    public ProxyClothesFactory(ClothesFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceClothes() {
        System.out.println("Proxy factory do something before...");

        factory.produceClothes();

        System.out.println("Proxy factory do something ending...");
    }
}

// 被代理类
class NikeClothesFactory implements ClothesFactory {

    @Override
    public void produceClothes() {
        System.out.println("Nike factory produce clothes !");
    }
}

interface ClothesFactory {
    /**
     * produce clothes
     */
    void produceClothes();
}
