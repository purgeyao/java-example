package com.purgeteam.custom.interceptor.test;

import com.purgeteam.custom.interceptor.function.ClassInstanceMethodsEnhance;
import com.purgeteam.custom.interceptor.function.methods.InstanceMethodsInterceptPoint;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author purgeyao
 * @since 1.0
 */
public class TestClassInstanceMethodsEnhance implements ClassInstanceMethodsEnhance {

    private static final String ENHANCE_CLASS = "com.purgeteam.custom.interceptor.test.GreetingInterceptor";
    private static final String INTERCEPT_CLASS = "com.purgeteam.custom.interceptor.test.TestInstanceMethodsAroundInterceptor";

    @Override
    public String enhanceClass() {
        return ENHANCE_CLASS;
    }

    @Override
    public InstanceMethodsInterceptPoint getInstanceMethodsInterceptPoints() {
       return new InstanceMethodsInterceptPoint() {
            @Override
            public ElementMatcher<MethodDescription> getMethodsMatcher() {
                return named("apply");
            }

            @Override
            public String getMethodsInterceptor() {
                return INTERCEPT_CLASS;
            }
        };
    }
}
