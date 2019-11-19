package com.purgeteam.bytecode.bytebuddy;

/**
 * @author purgeyao
 * @since 1.0
 */
public class GreetingInterceptor {

    public Object greet(Object argument) {
        return "Hello from " + argument;
    }
}
