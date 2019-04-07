package com.purge.demo.consumer;

import com.purge.demo.function.FunctionalInterfaceDemo;

import java.util.function.Consumer;

/**
 * @author purgeyao
 * @version 1.0
 * @date 2019-04-07
 */
public class ConsumerDemo {

    public static void print(Consumer<? super CharSequence> cs, String message) {
        cs.accept(message);
    }

    private static void echo(String message) {
        System.out.println("echo : " + message);
    }

    public static void main(String[] args) {

        Consumer consumer = System.out::println;

        consumer.accept("Hello,World");

        Consumer<String> consumer1 = ConsumerDemo::echo;

        consumer1.andThen(consumer).andThen(consumer).accept("Hello");
    }
}
