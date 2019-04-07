package com.purge.demo.function;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * {@link Function}
 * @author purgeyao
 * @version 1.0
 * @date 2019-04-07
 */
public class FunctionDemo {

    public static void main(String[] args) {

        // string -> long
        Function<String, Long> stringToLong = Long::valueOf;

        System.out.println(stringToLong.apply("123"));

        // long -> string
        Function<Long, String> longToString = String::valueOf;

        System.out.println(longToString.apply(1L));


        // "1" -> 1L -> "1"
        Long apply = stringToLong.compose(String::valueOf).apply(1L);

    }
}
