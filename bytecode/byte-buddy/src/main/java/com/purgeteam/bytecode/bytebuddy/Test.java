package com.purgeteam.bytecode.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.function.Function;

/**
 * @author purgeyao
 * @since 1.0
 */
public class Test {

    private static final String ENHANCE_CLASS = "com.purgeteam.bytecode.bytebuddy.GreetingInterceptor";

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {


        GreetingInterceptor greetingInterceptor = new GreetingInterceptor();
        Class<?> aClass = Class.forName(ENHANCE_CLASS);
        ElementMatcher.Junction<NamedElement> apply = ElementMatchers.named("apply");
        MethodDelegation methodDelegation = MethodDelegation.to(greetingInterceptor);

        Class<? extends Function> dynamicType = new ByteBuddy()
                .subclass(Function.class)
                .method(apply)
                .intercept(methodDelegation)
                .make()
                .load(Test.class.getClassLoader())
                .getLoaded();

        String byte_buddy = (String) dynamicType.newInstance().apply("Byte Buddy11");
        System.out.println(byte_buddy);

    }
}
