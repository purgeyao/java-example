package com.purgeteam.custom.interceptor.function.methods;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;

/**
 * 实例方法截点
 *
 * @author purgeyao
 * @since 1.0
 */
public interface InstanceMethodsInterceptPoint {

    /**
     * 类实例方法匹配器。
     *
     * @return methods matcher
     */
    ElementMatcher<MethodDescription> getMethodsMatcher();

    /**
     * @return 表示类名，类实例必须instanceof InstanceMethodsAroundInterceptor。
     */
    String getMethodsInterceptor();
}
