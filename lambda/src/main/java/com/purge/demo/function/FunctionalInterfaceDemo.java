package com.purge.demo.function;

/**
 * @author purgeyao
 * @version 1.0
 * @date 2019-04-07
 */
public class FunctionalInterfaceDemo {

    @FunctionalInterface
    public interface Function1 {

        public abstract void execute();

        default String getDescription() {
            return String.valueOf(this);
        }
    }

    //    @FunctionalInterface // @FunctionalInterface 并非必选的 并且只能描述接口
    public interface FunctionalInterfaceWithoutAnnotation {

        void execute();
    }

    public static void main(String[] args) {

        Function1 function1 = () -> {

        };


        FunctionalInterfaceWithoutAnnotation f2 = () -> {
        };
    }
}
