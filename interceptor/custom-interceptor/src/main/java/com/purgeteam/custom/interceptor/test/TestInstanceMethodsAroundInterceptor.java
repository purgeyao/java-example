package com.purgeteam.custom.interceptor.test;

import com.purgeteam.custom.interceptor.function.interceptor.EnhancedInstance;
import com.purgeteam.custom.interceptor.function.interceptor.InstanceMethodsAroundInterceptor;
import com.purgeteam.custom.interceptor.function.interceptor.MethodInterceptResult;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author purgeyao
 * @since 1.0
 */
@Slf4j
public class TestInstanceMethodsAroundInterceptor implements InstanceMethodsAroundInterceptor {

    @Override
    public void beforeMethod(EnhancedInstance objInst, Method method, Object[] allArguments, Class<?>[] argumentsTypes, MethodInterceptResult result) throws Throwable {
        log.info("beforeMethod");
    }

    @Override
    public Object afterMethod(EnhancedInstance objInst, Method method, Object[] allArguments, Class<?>[] argumentsTypes, Object ret) throws Throwable {
        log.info("afterMethod");
        return null;
    }

    @Override
    public void handleMethodException(EnhancedInstance objInst, Method method, Object[] allArguments, Class<?>[] argumentsTypes, Throwable t) {
        log.info("handleMethodException");
    }
}
