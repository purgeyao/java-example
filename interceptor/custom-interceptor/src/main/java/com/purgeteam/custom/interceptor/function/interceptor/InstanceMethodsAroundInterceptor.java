package com.purgeteam.custom.interceptor.function.interceptor;

import java.lang.reflect.Method;

/**
 * @author purgeyao
 * @since 1.0
 */
public interface InstanceMethodsAroundInterceptor {
    /**
     * 在目标方法调用之前调用。
     *
     * @param result 如果要截断方法，请更改此结果。
     * @throws Throwable
     */
    void beforeMethod(EnhancedInstance objInst, Method method, Object[] allArguments, Class<?>[] argumentsTypes,
                      MethodInterceptResult result) throws Throwable;

    /**
     * 在目标方法调用后调用。甚至方法的调用也会触发异常。
     *
     * @param method
     * @param ret    方法的原始返回值。
     * @return 方法的实际返回值。
     * @throws Throwable
     */
    Object afterMethod(EnhancedInstance objInst, Method method, Object[] allArguments, Class<?>[] argumentsTypes,
                       Object ret) throws Throwable;

    /**
     * 当发生异常时调用。
     *
     * @param method
     * @param t      异常发生。
     */
    void handleMethodException(EnhancedInstance objInst, Method method, Object[] allArguments,
                               Class<?>[] argumentsTypes,
                               Throwable t);
}
