package com.purgeteam.dynamic.proxy;

import java.lang.reflect.Proxy;

/**
 * @author purgeyao
 * @since 1.0
 */
public class App {

    public static void main(String[] args) {
        // 创建类
        Object realImage = new RealImage();

        ClassLoader classLoader = realImage.getClass().getClassLoader();
        Class<?>[] interfaces = realImage.getClass().getInterfaces();
        TransactionHandler transactionHandler = new TransactionHandler(realImage);
        Image proxyImage = (Image) Proxy.newProxyInstance(classLoader, interfaces, transactionHandler);
        boolean proxyClass = Proxy.isProxyClass(proxyImage.getClass());
        boolean proxyClass1 = Proxy.isProxyClass(realImage.getClass());

        proxyImage.display();
    }
}
