package com.purgeteam.dynamic.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author purgeyao
 * @since 1.0
 */
@Slf4j
public class TransactionHandler implements InvocationHandler {

    private static final String TAG = "TransactionHandler";

    Object target;

    public TransactionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info(TAG, "Before invoke target's method...");
        Object result = method.invoke(target, args);
        log.info(TAG, "After invoke target's method...");
        return result;
    }
}
