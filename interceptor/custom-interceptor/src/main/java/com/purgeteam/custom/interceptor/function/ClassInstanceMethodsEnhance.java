package com.purgeteam.custom.interceptor.function;

import com.purgeteam.custom.interceptor.function.methods.InstanceMethodsInterceptPoint;

/**
 * 类增强器
 *
 * @author purgeyao
 * @since 1.0
 */
public interface ClassInstanceMethodsEnhance {

    /**
     * 需要增强的类
     */
    String enhanceClass();

    /**
     * 需要增强的方法
     */
    InstanceMethodsInterceptPoint getInstanceMethodsInterceptPoints();

}
