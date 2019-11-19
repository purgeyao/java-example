package com.purgeteam.custom.interceptor.test;

import com.purgeteam.custom.interceptor.function.methods.InstanceMethodsInterceptPoint;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatcher;

import java.util.function.Function;

/**
 * @author purgeyao
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 类增强器
        TestClassInstanceMethodsEnhance instanceMethodsEnhance = new TestClassInstanceMethodsEnhance();

        // 获取需要增强的方法
        InstanceMethodsInterceptPoint point = instanceMethodsEnhance.getInstanceMethodsInterceptPoints();
        // 类实例方法匹配器
        ElementMatcher<MethodDescription> methodsMatcher = point.getMethodsMatcher();
        // 自定义拦截器
        String methodsInterceptor = point.getMethodsInterceptor();

        Class<? extends Function> dynamicType = new ByteBuddy()
                .subclass(Function.class)
                // 方法
                .method(methodsMatcher)
                // 类
//                .intercept(MethodDelegation.to(new GreetingInterceptor()))
                .intercept(MethodDelegation.to(new TestInstanceMethodsAroundInterceptor()))
                .make()
                .load(Test.class.getClassLoader())
                .getLoaded();

        String byte_buddy = (String) dynamicType.newInstance().apply("Byte Buddy11");
        System.out.println(byte_buddy);

    }
}
